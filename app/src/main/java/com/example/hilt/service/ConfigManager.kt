package com.example.hilt.service

import com.example.hilt.model.ConfigModel
import com.example.hilt.utils.Failure
import com.example.hilt.utils.Result
import com.example.hilt.utils.onSuccess
import javax.inject.Inject

class ConfigManager @Inject constructor(
    private val service: MovieService
) {

    private var config: ConfigModel? = null

    suspend fun getConfig(): Result<Failure, ConfigModel> {
        return config?.let {
            Result.Success(it)
        } ?: service.getConfig().onSuccess {
            config = it
            Result.Success(it)
        }
    }
}