package com.fpadilha90.movies.di

import android.content.ContentResolver
import com.fpadilha90.movies.data.di.ApiInject
import com.fpadilha90.movies.data.di.DataInject
import com.fpadilha90.movies.home.di.HomeInject
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object AppInject {
    private val appModules = module {
        single<ContentResolver> { androidContext().contentResolver }
        single { Executors.newSingleThreadExecutor() as Executor }
    }

    val modules: List<Module>
        get() {
            return ArrayList<Module>().apply {
                add(appModules)
                addAll(HomeInject.modules)
                addAll(DataInject.modules)
                addAll(ApiInject.modules)
            }
        }
}