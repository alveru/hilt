package com.example.hilt.model

import com.google.gson.annotations.SerializedName

data class MovieModel(

    var id: Int = 0,
    var title: String = "",
    var adult: Boolean = false,
    var overview: String = "",

    @SerializedName("vote_count")
    val voteCount: Int = 0,

    @SerializedName("vote_average")
    var voteAverage: Float = 0.0F,

    @SerializedName("poster_path")
    var posterPath: String = "",

    @SerializedName("original_language")
    var originalLanguage: String = "",

    @SerializedName("release_date")
    var releaseDate: String = ""

)