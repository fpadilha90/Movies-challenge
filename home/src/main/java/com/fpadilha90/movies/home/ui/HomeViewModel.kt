package com.fpadilha90.movies.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.fpadilha90.movies.home.repository.ShowRepository

class HomeViewModel(showRepository: ShowRepository) : ViewModel() {
    val page = MutableLiveData<Int>()
    val repoResult = map(page) {
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
        repoResult.value?.retry?.invoke()
    }

    companion object {
        const val FIRST_PAGE = 1
    }
}