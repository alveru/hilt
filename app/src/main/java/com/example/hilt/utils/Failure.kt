package com.example.hilt.utils

sealed class Failure {
    data class CustomError(val error: String) : Failure()
    object NoContent : Failure()
}