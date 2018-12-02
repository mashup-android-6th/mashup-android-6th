package com.mashup.mashup_android_6th.models

data class MoveData(
    val movie_count: Int,
    val limit: Int,
    val page_number: Int,
    val movies: List<Movie>
)