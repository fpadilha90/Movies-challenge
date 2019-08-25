package com.fpadilha90.movies.home.repository

import com.fpadilha90.movies.common.model.Listing
import com.fpadilha90.movies.common.model.Movie

interface MovieRepository {
    fun getPopularTVShows() : Listing<Movie>
}