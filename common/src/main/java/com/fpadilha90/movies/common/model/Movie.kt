package com.fpadilha90.movies.common.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(
    tableName = "movies",
    indices = [Index(value = ["id", "page"], unique = true)]
)
data class Movie(
    @field:Json(name="poster_path")
    val posterPath: String?,
    val popularity: Double,
    @PrimaryKey
    val id: Long,
    @field:Json(name="backdrop_path")
    val backdropPath: String?,
    @field:Json(name="vote_average")
    val voteAverage: Double,
    val overview: String,
    @field:Json(name="first_air_date")
    val firstAirDate: String,
    @field:Json(name="original_language")
    val originalLanguage: String,
    @field:Json(name="vote_count")
    val voteCount: Int,
    val name: String,
    @field:Json(name="original_name")
    val originalName: String,
    var page: Int
)