package com.fpadilha90.movies.data.api

import com.fpadilha90.movies.data.model.GetPopularDTO
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("3/tv/popular")
    fun getPopular(): Call<GetPopularDTO>
}