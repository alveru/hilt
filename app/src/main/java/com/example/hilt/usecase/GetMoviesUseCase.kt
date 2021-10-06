package com.example.hilt.usecase

import com.example.hilt.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun getMovieList() = withContext(Dispatchers.IO) {
        movieService.getMovieList()
    }
}