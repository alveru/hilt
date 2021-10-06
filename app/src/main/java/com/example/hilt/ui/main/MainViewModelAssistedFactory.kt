package com.example.hilt.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.AssistedFactory

@AssistedFactory
interface MainViewModelAssistedFactory {
    fun create(id: Any): MainViewModel
}

class Factory(
    private val assistedFactory: MainViewModelAssistedFactory,
    private val id: Any
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return assistedFactory.create(id) as T
    }
}