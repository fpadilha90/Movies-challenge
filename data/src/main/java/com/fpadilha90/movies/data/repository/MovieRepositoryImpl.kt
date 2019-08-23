package com.fpadilha90.movies.data.repository

import com.example.common.domain.exception.Failure
import com.fpadilha90.movies.common.functional.Either
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.home.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getPopularTVShows(): Either<Failure, List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}