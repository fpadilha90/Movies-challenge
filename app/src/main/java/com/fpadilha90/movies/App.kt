package com.fpadilha90.movies

import android.app.Application
import com.fpadilha90.movies.di.AppInject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(AppInject.modules)
        }
    }
}