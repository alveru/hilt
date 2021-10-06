package com.example.hilt.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt.service.ConfigManager
import com.example.hilt.utils.onFailure
import com.example.hilt.utils.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val configManager: ConfigManager,
) : ViewModel() {

    private val _showRetry = MutableLiveData(false)
    val showRetry: LiveData<Boolean> get() = _showRetry

    private val _loaded = MutableLiveData<Boolean>()
    fun isLoaded(): LiveData<Boolean> = _loaded

    init {
        load()
    }

    fun load() {
        viewModelScope.launch(context = Dispatchers.IO) {
            _showRetry.postValue(false)
            configManager.getConfig()
                .onSuccess {
                    _loaded.postValue(true)
                }
                .onFailure {
                    _showRetry.postValue(true)
                }
        }
    }
}