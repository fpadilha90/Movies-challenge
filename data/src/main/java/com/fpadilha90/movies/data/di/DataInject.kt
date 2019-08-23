package com.fpadilha90.movies.data.di

import org.koin.core.module.Module
import org.koin.dsl.module

object DataInject {

    private val repositoryModule = module {
    }

    val modules: List<Module> = listOf(repositoryModule)

}