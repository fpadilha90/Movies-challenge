package com.fpadilha90.movies.home.repository

import com.example.common.domain.exception.Failure
import com.fpadilha90.movies.common.functional.Either
import com.fpadilha90.movies.common.model.Movie

interface MovieRepository {
    suspend fun getPopularTVShows() : Either<Failure, List<Movie>>
}