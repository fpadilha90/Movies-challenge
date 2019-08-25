package com.fpadilha90.movies.data.repository

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.toLiveData
import com.fpadilha90.movies.common.model.Listing
import com.fpadilha90.movies.common.model.Movie
import com.fpadilha90.movies.common.model.NetworkState
import com.fpadilha90.movies.data.api.MovieService
import com.fpadilha90.movies.data.db.MovieDb
import com.fpadilha90.movies.data.model.MovieListDTO
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

    private fun insertResultIntoDb(body: MovieListDTO) {
        body.results.let { movies ->
            movies.map { it.page = body.page }
            db.runInTransaction {
                //                val start = db.movies().getNextIndexInSubreddit(subredditName)
//                val items = moviesDTO.mapIndexed { index, child ->
//                    child.data.indexInResponse = start + index
//                    child
//                }
                db.movies().insert(movies)
            }
        }
    }

    private fun refresh(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        movieService.getPopular(1).enqueue(
            object : Callback<MovieListDTO> {
                override fun onFailure(call: Call<MovieListDTO>, t: Throwable) {
                    // retrofit calls this on main thread so safe to call set value
                    networkState.value = NetworkState.error(t.message)
                }

                override fun onResponse(
                    call: Call<MovieListDTO>,
                    response: Response<MovieListDTO>
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

    override fun getPopularTVShows(): Listing<Movie> {
        val boundaryCallback = MovieBoundaryCallback(
            movieService = movieService,
            handleResponse = this::insertResultIntoDb,
            ioExecutor = ioExecutor
        )
        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger) {
            refresh()
        }

        val livePagedList = db.movies().movies().toLiveData(
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