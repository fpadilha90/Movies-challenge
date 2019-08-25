package com.fpadilha90.movies.data.di

import com.fpadilha90.movies.data.BuildConfig
import com.fpadilha90.movies.data.api.TheMovieDbApi
import org.koin.core.module.Module
import org.koin.dsl.module

object ApiInject {

    private val serviceModule = module {
        single {
            TheMovieDbApi.create(BuildConfig.HOST, BuildConfig.API_KEY, BuildConfig.DEBUG)
        }
    }

    val modules: List<Module> = listOf(serviceModule)
}