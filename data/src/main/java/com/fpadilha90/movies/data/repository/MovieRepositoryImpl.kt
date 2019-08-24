package com.fpadilha90.movies.data.repository

import com.example.common.domain.exception.Failure
import com.fpadilha90.movies.common.functional.Either
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.data.api.MovieService
import com.fpadilha90.movies.home.repository.MovieRepository

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {
    override suspend fun getPopularTVShows(): Either<Failure, List<Movie>> {
        return Either.Right(movieService.getPopular().await()
            .body()!!
            .results
            .map {
                Movie(it.poster_path, it.popularity, it.id, it.backdrop_path, it.vote_average, it.overview, it.name)
            })
    }

}