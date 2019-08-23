package com.fpadilha90.movies.common.model

data class Movie(
    val posterPath: String,
    val popularity: Double,
    val id: Long,
    val backdropPath: String,
    val voteAverage: Double,
    val overview: String,
    val name: String
)