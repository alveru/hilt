package com.example.hilt.model

import com.google.gson.annotations.SerializedName

data class MovieListModel(
    val page: Int,
    val results: List<MovieModel>,
    @SerializedName("total_pages")
    val totalPages: Int
)