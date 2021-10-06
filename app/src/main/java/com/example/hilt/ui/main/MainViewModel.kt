package com.example.hilt.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.model.MovieModel
import com.example.hilt.service.ConfigManager
import com.example.hilt.usecase.GetMoviesUseCase
import com.example.hilt.utils.onFailure
import com.example.hilt.utils.onSuccess
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @AssistedInject constructor(
    private val moviesUseCase: GetMoviesUseCase,
    private val configManager: ConfigManager,
    @Assisted private val id: Any  // This parameter is just a test for custom injected parameters
) : ViewModel() {

    private val _movieList = MutableLiveData<List<MovieModel>>()
    fun movieList(): LiveData<List<MovieModel>> = _movieList

    init {
        load()
    }

    private fun load() {

        viewModelScope.launch(context = Dispatchers.IO) {
            configManager.getConfig()
                .onSuccess { config ->
                    moviesUseCase.getMovieList()
                        .onSuccess { model ->
                            _movieList.postValue(model.results.map {
                                it.copy(posterPath = config.getImagePath(it.posterPath))
                            })
                        }
                        .onFailure {

                        }
                }
                .onFailure {
                    Log.e("error-->", it.toString())
                }
        }
    }
}