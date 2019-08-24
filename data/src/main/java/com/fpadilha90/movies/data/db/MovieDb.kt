package com.fpadilha90.movies.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fpadilha90.movies.common.model.Movie


@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDb : RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory : Boolean): MovieDb {
            val databaseBuilder = if(useInMemory) {
                Room.inMemoryDatabaseBuilder(context, MovieDb::class.java)
            } else {
                Room.databaseBuilder(context, MovieDb::class.java, "movie.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun movies() : MovieDao
}