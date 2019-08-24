package com.fpadilha90.movies.data.repository

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.toLiveData
import com.fpadilha90.movies.common.functional.Listing
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.data.api.MovieService
import com.fpadilha90.movies.data.db.MovieDb
import com.fpadilha90.movies.data.model.GetPopularDTO
import com.fpadilha90.movies.home.repository.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor


class MovieRepositoryImpl(
    val db: MovieDb,
    private val movieService: MovieService,
    private val ioExecutor: Executor
) : MovieRepository {

    /**
     * Inserts the response into the database while also assigning position indices to items.
     */
    private fun insertResultIntoDb(body: GetPopularDTO) {
        body.results.let { moviesDTO ->
            db.runInTransaction {
                //                val start = db.movies().getNextIndexInSubreddit(subredditName)
//                val items = moviesDTO.mapIndexed { index, child ->
//                    child.data.indexInResponse = start + index
//                    child
//                }
                db.movies().insert(moviesDTO)
            }
        }
    }

    /**
     * When refresh is called, we simply run a fresh network request and when it arrives, clear
     * the database table and insert all new items in a transaction.
     * <p>
     * Since the PagedList already uses a database bound data source, it will automatically be
     * updated after the database transaction is finished.
     */
    @MainThread
    private fun refresh(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        movieService.getPopular().enqueue(
            object : Callback<GetPopularDTO> {
                override fun onFailure(call: Call<GetPopularDTO>, t: Throwable) {
                    // retrofit calls this on main thread so safe to call set value
                    networkState.value = NetworkState.error(t.message)
                }

                override fun onResponse(
                    call: Call<GetPopularDTO>,
                    response: Response<GetPopularDTO>
                ) {
                    ioExecutor.execute {
                        db.runInTransaction {
                            //                            db.movies().deleteBySubreddit(subredditName)
                            response.body()?.let { insertResultIntoDb(it) }
                        }
                        // since we are in bg thread now, post the result.
                        networkState.postValue(NetworkState.LOADED)
                    }
                }
            }
        )
        return networkState
    }

    /**
     * Returns a Listing
     */
    override fun getPopularTVShows(): Listing<Movie> {
        // create a boundary callback which will observe when the user reaches to the edges of
        // the list and update the database with extra data.
        val boundaryCallback = MovieBoundaryCallback(
            movieService = movieService,
            handleResponse = this::insertResultIntoDb,
            ioExecutor = ioExecutor
        )
        // we are using a mutable live data to trigger refresh requests which eventually calls
        // refresh method and gets a new live data. Each refresh request by the user becomes a newly
        // dispatched data in refreshTrigger
        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger) {
            refresh()
        }

        // We use toLiveData Kotlin extension function here, you could also use LivePagedListBuilder
        val livePagedList = db.movies().movies().toLiveData(
            pageSize = 15,
            boundaryCallback = boundaryCallback
        )

        return Listing(
            pagedList = livePagedList,
            networkState = boundaryCallback.networkState,
            retry = {
                boundaryCallback.helper.retryAllFailed()
            },
            refresh = {
                refreshTrigger.value = null
            },
            refreshState = refreshState
        )
    }
}