package com.fpadilha90.movies.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "movies",
    indices = [Index(value = ["id"], unique = true)]
)
data class MovieDTO(
    val poster_path: String,
    val popularity: Double,
    @PrimaryKey
    val id: Long,
    val backdrop_path: String,
    val vote_average: Double,
    val overview: String,
    val first_air_date: String,
//    val origin_country: List<String>,
//    val genre_ids: List<Int>,
    val original_language: String,
    val vote_count: Int,
    val name: String,
    val original_name: String
)