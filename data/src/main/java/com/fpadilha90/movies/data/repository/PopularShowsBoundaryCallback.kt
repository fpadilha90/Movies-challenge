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
import com.fpadilha90.movies.data.utils.createStatusLiveData
import com.fpadilha90.movies.common.model.Show
import com.fpadilha90.movies.data.utils.PagingRequestHelper
import com.fpadilha90.movies.data.api.TheMovieDbService
import com.fpadilha90.movies.data.model.ShowsListDTO
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
class PopularShowsBoundaryCallback(
    private val webservice: TheMovieDbService,
    private val handleResponse: (ShowsListDTO) -> Unit,
    private val ioExecutor: Executor
) : PagedList.BoundaryCallback<Show>() {

    private var page: Int = FIRST_PAGE
    val helper = PagingRequestHelper(ioExecutor)
    val networkState = helper.createStatusLiveData()

    @MainThread
    override fun onZeroItemsLoaded() {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.INITIAL) {
            webservice.getPopularShows(page).enqueue(createWebserviceCallback(it))
        }
    }

    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: Show) {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.AFTER) {
            page += 1
            webservice.getPopularShows(page).enqueue(createWebserviceCallback(it))
        }
    }

    private fun insertItemsIntoDb(
        response: Response<ShowsListDTO>,
        it: PagingRequestHelper.Request.Callback
    ) {
        ioExecutor.execute {
            handleResponse(response.body()!!)

            it.recordSuccess()
        }
    }

    override fun onItemAtFrontLoaded(itemAtFront: Show) {
    }

    private fun createWebserviceCallback(it: PagingRequestHelper.Request.Callback)
            : Callback<ShowsListDTO> {
        return object : Callback<ShowsListDTO> {
            override fun onFailure(
                call: Call<ShowsListDTO>,
                t: Throwable
            ) {
                it.recordFailure(t)
            }

            override fun onResponse(
                call: Call<ShowsListDTO>,
                response: Response<ShowsListDTO>
            ) {
                insertItemsIntoDb(response, it)
            }
        }
    }

    companion object {
        const val FIRST_PAGE: Int = 1
    }
}