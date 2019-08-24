package com.fpadilha90.movies.data.api

import com.fpadilha90.movies.data.model.GetPopularDTO
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("3/tv/popular")
    fun getPopular(): Deferred<Response<GetPopularDTO>>
}