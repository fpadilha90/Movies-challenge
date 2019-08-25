package com.fpadilha90.movies.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class TheMovieDbApi {
    companion object {
        private const val API_KEY_PARAM = "api_key"

        fun create(baseUrl: String, apiKey: String, debug: Boolean = false): TheMovieDbService {
            val clientBuilder = OkHttpClient.Builder()
            if (debug) {
                val httpLoggingInterceptor =
                    HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                clientBuilder.addInterceptor(httpLoggingInterceptor)
            }
            clientBuilder.addInterceptor(apiKeyInterceptor(apiKey))

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(TheMovieDbService::class.java)
        }

        private fun apiKeyInterceptor(apiKey : String) = Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY_PARAM, apiKey)
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}