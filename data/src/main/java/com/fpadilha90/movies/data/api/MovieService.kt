package com.fpadilha90.movies.data.api

import com.fpadilha90.movies.data.model.ShowsListDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("3/tv/popular")
    fun getPopularShows(@Query("page") page: Int): Call<ShowsListDTO>
}