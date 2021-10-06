package com.example.hilt.service

import com.example.hilt.model.ConfigModel
import com.example.hilt.model.MovieListModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/3/configuration?api_key=debf8baf72c374313a90211df0fbce07")
    suspend fun getConfig() : Response<ConfigModel>

    @GET("/3/discover/movie?sort_by=popularity.desc&api_key=debf8baf72c374313a90211df0fbce07")
    suspend fun getMovieList(): Response<MovieListModel>
}