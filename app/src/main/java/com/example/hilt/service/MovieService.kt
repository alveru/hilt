package com.example.hilt.service

import com.example.hilt.model.ConfigModel
import com.example.hilt.model.MovieListModel
import com.example.hilt.utils.Failure
import com.example.hilt.utils.Result
import com.example.hilt.utils.request
import javax.inject.Inject

class MovieService @Inject constructor(
    val movieApiService: ApiService
) {

    suspend fun getConfig(): Result<Failure, ConfigModel> {
        return request { movieApiService.getConfig() }
    }

    suspend fun getMovieList(): Result<Failure, MovieListModel> {
        return request { movieApiService.getMovieList() }
    }

}