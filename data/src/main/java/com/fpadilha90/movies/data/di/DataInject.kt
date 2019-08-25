package com.fpadilha90.movies.data.di

import com.fpadilha90.movies.data.db.AppDb
import com.fpadilha90.movies.data.repository.ShowsRepositoryImpl
import com.fpadilha90.movies.home.repository.ShowRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DataInject {

    private val dbModule = module {
        single { AppDb.create(get(), false) }
    }
    private val repositoryModule = module {
        single<ShowRepository> { ShowsRepositoryImpl(get(), get(), get()) }
    }

    val modules: List<Module> = listOf(dbModule, repositoryModule)

}