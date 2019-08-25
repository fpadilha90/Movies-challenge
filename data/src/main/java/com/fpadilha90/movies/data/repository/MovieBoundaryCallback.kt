/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fpadilha90.movies.data.repository

import androidx.annotation.MainThread
import androidx.paging.PagedList
import com.fpadilha90.movies.common.extension.createStatusLiveData
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.common.utils.PagingRequestHelper
import com.fpadilha90.movies.data.api.MovieService
import com.fpadilha90.movies.data.model.MovieListDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

/**
 * This boundary callback gets notified when user reaches to the edges of the list such that the
 * database cannot provide any more data.
 * <p>
 * The boundary callback might be called multiple times for the same direction so it does its own
 * rate limiting using the PagingRequestHelper class.
 */
class MovieBoundaryCallback(
    private val movieService: MovieService,
    private val handleResponse: (MovieListDTO) -> Unit,
    private val ioExecutor: Executor
) : PagedList.BoundaryCallback<Movie>() {

    private var totalPages: Int = 0
    private var page: Int = 1
    val helper = PagingRequestHelper(ioExecutor)
    val networkState = helper.createStatusLiveData()

    @MainThread
    override fun onZeroItemsLoaded() {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.INITIAL) {
            movieService.getPopular(page).enqueue(createWebserviceCallback(it))
        }
    }

    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: Movie) {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.AFTER) {
            page += 1
            if (totalPages >= page){
                movieService.getPopular(page).enqueue(createWebserviceCallback(it))
            } else {
                networkState.postValue(NetworkState.LOADED)
            }
        }
    }

    private fun insertItemsIntoDb(
        response: Response<MovieListDTO>,
        it: PagingRequestHelper.Request.Callback
    ) {
        ioExecutor.execute {
            response.body()!!.let {
                totalPages = it.total_pages
                handleResponse(it)
            }

            it.recordSuccess()
        }
    }

    override fun onItemAtFrontLoaded(itemAtFront: Movie) {
    }

    private fun createWebserviceCallback(it: PagingRequestHelper.Request.Callback)
            : Callback<MovieListDTO> {
        return object : Callback<MovieListDTO> {
            override fun onFailure(
                call: Call<MovieListDTO>,
                t: Throwable
            ) {
                it.recordFailure(t)
            }

            override fun onResponse(
                call: Call<MovieListDTO>,
                response: Response<MovieListDTO>
            ) {
                insertItemsIntoDb(response, it)
            }
        }
    }
}