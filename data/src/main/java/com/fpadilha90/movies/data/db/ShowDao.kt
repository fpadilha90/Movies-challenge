package com.fpadilha90.movies.data.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fpadilha90.movies.common.model.Show

@Dao
interface ShowDao {
    @Query("SELECT * FROM shows ORDER BY page")
    fun getAll() : DataSource.Factory<Int, Show>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shows : List<Show>)

}