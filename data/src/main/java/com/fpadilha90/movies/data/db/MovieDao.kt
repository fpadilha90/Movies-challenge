package com.fpadilha90.movies.data.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.fpadilha90.movies.data.model.MovieDTO

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun movies() : DataSource.Factory<Int, MovieDTO>

}