package com.fpadilha90.movies.common.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(
    tableName = "movies",
    indices = [Index(value = ["id"], unique = true)]
)
data class Movie(
//    @Json(name="poster_path")
    val poster_path: String,
    val popularity: Double,
    @PrimaryKey
    val id: Long,
//    @Json(name="backdrop_path")
    val backdrop_path: String?,
    val vote_average: Double,
    val overview: String,
//    @Json(name="first_air_date")
    val first_air_date: String,
//    val origin_country: List<String>,
//    val genre_ids: List<Int>,
//    @Json(name="original_language")
    val original_language: String,
//    @Json(name="vote_count")
    val vote_count: Int,
    val name: String,
    val original_name: String
)