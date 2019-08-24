package com.fpadilha90.movies.data.api

import com.fpadilha90.movies.data.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MovieApi {
    companion object {
        private val apiKeyInterceptor: Interceptor = Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        fun create(baseUrl: String, debug: Boolean = false): MovieService {
            val clientBuilder = OkHttpClient.Builder()
            if (debug) {
                val httpLoggingInterceptor =
                    HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                clientBuilder.addInterceptor(httpLoggingInterceptor)
            }
            clientBuilder.addInterceptor(apiKeyInterceptor)

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(clientBuilder.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(MovieService::class.java)
        }
    }
}