package com.fpadilha90.movies.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.toLiveData
import com.fpadilha90.movies.common.model.Listing
import com.fpadilha90.movies.common.model.Show
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.data.api.MovieService
import com.fpadilha90.movies.data.db.AppDb
import com.fpadilha90.movies.data.model.ShowsListDTO
import com.fpadilha90.movies.data.repository.PopularShowsBoundaryCallback.Companion.FIRST_PAGE
import com.fpadilha90.movies.home.repository.ShowRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor


class ShowsRepositoryImpl(
    val db: AppDb,
    private val movieService: MovieService,
    private val ioExecutor: Executor
) : ShowRepository {

    private fun insertResultIntoDb(body: ShowsListDTO) {
        body.results.let { movies ->
            movies.map { it.page = body.page }
            db.runInTransaction {
                db.shows().insert(movies)
            }
        }
    }

    private fun refresh(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        movieService.getPopularShows(FIRST_PAGE).enqueue(
            object : Callback<ShowsListDTO> {
                override fun onFailure(call: Call<ShowsListDTO>, t: Throwable) {
                    networkState.value = NetworkState.error(t.message)
                }

                override fun onResponse(
                    call: Call<ShowsListDTO>,
                    response: Response<ShowsListDTO>
                ) {
                    ioExecutor.execute {
                        db.runInTransaction {
                            response.body()?.let { insertResultIntoDb(it) }
                        }
                        networkState.postValue(NetworkState.LOADED)
                    }
                }
            }
        )
        return networkState
    }

    override fun getPopularShows(): Listing<Show> {
        val boundaryCallback = PopularShowsBoundaryCallback(
            movieService = movieService,
            handleResponse = this::insertResultIntoDb,
            ioExecutor = ioExecutor
        )
        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger) {
            refresh()
        }

        val livePagedList = db.shows().getAll().toLiveData(
            pageSize = 20,
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