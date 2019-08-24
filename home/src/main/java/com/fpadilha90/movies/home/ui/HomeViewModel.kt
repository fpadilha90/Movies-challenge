package com.fpadilha90.movies.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fpadilha90.movies.common.model.Movie

class HomeViewModel : ViewModel() {
    val uiState = MutableLiveData<List<Movie>>()
}