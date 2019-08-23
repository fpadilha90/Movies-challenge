package com.fpadilha90.movies.data.api

import com.fpadilha90.movies.data.model.GetPopularDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("/tv/popular")
    fun getPopular(
        @Path("api_key") apiKey: String
    ): Call<GetPopularDTO>
}