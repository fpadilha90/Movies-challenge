package com.fpadilha90.movies.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.example.common.domain.exception.Failure
import com.fpadilha90.movies.home.repository.MovieRepository

class HomeViewModel(movieRepository: MovieRepository) : ViewModel() {
    private val page = MutableLiveData<Int>()
    private val repoResult = map(page) {
        movieRepository.getPopularTVShows()
    }
    val movies = Transformations.switchMap(repoResult) {
        it.pagedList
    }!!
    val networkState = Transformations.switchMap(repoResult) { it.networkState }!!
    val refreshState = Transformations.switchMap(repoResult) { it.refreshState }!!

    init {
        page.value = 1
    }

    fun refresh() {
        repoResult.value?.refresh?.invoke()
    }

    fun retry() {
        val listing = repoResult?.value
        listing?.retry?.invoke()
    }

    private fun handleError(failure: Failure) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}