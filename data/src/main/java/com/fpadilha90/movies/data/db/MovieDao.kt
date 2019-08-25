package com.fpadilha90.movies.data.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fpadilha90.movies.common.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY page")
    fun movies() : DataSource.Factory<Int, Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movies : List<Movie>)

}