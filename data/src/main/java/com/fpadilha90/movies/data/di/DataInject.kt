package com.fpadilha90.movies.data.di

import com.fpadilha90.movies.data.db.MovieDb
import com.fpadilha90.movies.data.repository.MovieRepositoryImpl
import com.fpadilha90.movies.home.repository.MovieRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DataInject {

    private val dbModule = module {
        single { MovieDb.create(get(), true) }
    }
    private val repositoryModule = module {
        single<MovieRepository> { MovieRepositoryImpl(get(), get(), get()) }
    }

    val modules: List<Module> = listOf(dbModule, repositoryModule)

}