package com.fpadilha90.movies.data.di

import com.fpadilha90.movies.data.api.MovieService
import com.fpadilha90.movies.data.api.MovieServiceMock
import com.fpadilha90.movies.data.repository.MovieRepositoryImpl
import com.fpadilha90.movies.home.repository.MovieRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object ApiInject {

    private val serviceModule = module {
        single<MovieService> { MovieServiceMock() }
    }

    val modules: List<Module> = listOf(serviceModule)

}