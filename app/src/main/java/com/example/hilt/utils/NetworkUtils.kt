package com.example.hilt.utils

import retrofit2.Response

inline fun <T> request(
    call: () -> Response<T>
): Result<Failure, T> {
    return try {
        val response = call.invoke()
        if (response.isSuccessful && response.body() != null) {
            Result.Success(response.body()!!)
        } else {
            Result.Failure(Failure.NoContent)
        }
    } catch (ex: Exception) {
        Result.Failure(Failure.CustomError(ex.toString()))
    }
}