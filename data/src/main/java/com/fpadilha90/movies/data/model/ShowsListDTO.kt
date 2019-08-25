package com.fpadilha90.movies.data.model

import com.fpadilha90.movies.common.model.Show

data class ShowsListDTO(
    val page: Int,
    val results: List<Show>,
    val total_results: Int,
    val total_pages: Int
)