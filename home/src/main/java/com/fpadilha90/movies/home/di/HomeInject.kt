package com.fpadilha90.movies.home.di

import com.fpadilha90.movies.home.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


object HomeInject {

    private val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
    }

    val modules: List<Module> = listOf(viewModelModule)

}