package com.fpadilha90.movies.data.repository

import com.fpadilha90.movies.data.api.TheMovieDbService
import com.fpadilha90.movies.data.db.AppDb
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.Executor

class ShowsRepositoryImplTest {

    private lateinit var db: AppDb
    private lateinit var webservice: TheMovieDbService
    private lateinit var ioExecutor: Executor
    private lateinit var repository: ShowsRepositoryImpl

    @Before
    fun setUp() {
        db = mock{ }
        webservice = mock{ }
        ioExecutor = mock{ }

        repository = ShowsRepositoryImpl(db, webservice, ioExecutor)
        //        var listing = repository.getPopularShows()
    }

    @Test
    fun getPopularShowsShouldReturnTheListing(){

    }

    @Test
    fun getPopularShowsShouldCreateTheLiveData(){

    }
    @Test
    fun getPopularShowsShouldCreateTheBoundary(){

    }
    @Test
    fun getPopularShowsShouldCreateTheRefreshTrigger(){

    }
    @Test
    fun refreshShouldSetNetworkStateAsLoading(){

    }
    @Test
    fun refreshShouldRecallTheWebservice(){

    }
    @Test
    fun insertResultIntoDbShouldSetThePagesOnTheShows(){

    }
    @Test
    fun insertResultIntoDbShouldCallTheDbInsertTransaction(){

    }
}