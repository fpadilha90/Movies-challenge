package com.fpadilha90.movies.data.model

data class GetPopularDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val total_results: Int,
    val total_pages: Int
)