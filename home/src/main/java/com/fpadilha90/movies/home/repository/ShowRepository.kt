package com.fpadilha90.movies.home.repository

import com.fpadilha90.movies.common.model.Listing
import com.fpadilha90.movies.common.model.Show

interface ShowRepository {
    fun getPopularShows() : Listing<Show>
}