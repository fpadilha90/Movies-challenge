package com.fpadilha90.movies.di

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor


open class AppExecutors(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor = MainThreadExecutor()) {


    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}