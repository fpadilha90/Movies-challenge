package com.fpadilha90.movies.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.fpadilha90.movies.home.repository.ShowRepository

class HomeViewModel(showRepository: ShowRepository) : ViewModel() {
    private val page = MutableLiveData<Int>()
    private val repoResult = map(page) {
        showRepository.getPopularShows()
    }
    val movies = Transformations.switchMap(repoResult) {
        it.pagedList
    }!!
    val networkState = Transformations.switchMap(repoResult) { it.networkState }!!
    val refreshState = Transformations.switchMap(repoResult) { it.refreshState }!!

    init {
        page.value = FIRST_PAGE
    }

    fun refresh() {
        repoResult.value?.refresh?.invoke()
    }

    fun retry() {
        val listing = repoResult?.value
        listing?.retry?.invoke()
    }

    companion object {
        const val FIRST_PAGE = 1
    }
}