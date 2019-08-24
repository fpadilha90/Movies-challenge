package com.fpadilha90.movies.data.model

import com.fpadilha90.movies.common.model.Movie

data class GetPopularDTO(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
)