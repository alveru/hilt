package com.example.hilt.utils

sealed class Result<out L, out R> {

    data class Failure<out L>(val a: L) : Result<L, Nothing>()

    data class Success<out R>(val b: R) : Result<Nothing, R>()

    val isSuccess get() = this is Success<R>

    val isFailure get() = this is Failure<L>

    fun <R> success(b: R) = Success(b)

    fun <L> failure(a: L) = Failure(a)

    fun getOrNull() = if (this is Success) b else null
}


inline fun <L, R> Result<L, R>.onFailure(fn: (failure: L) -> Unit): Result<L, R> {
    return this.apply { if (this is Result.Failure) fn.invoke(a) }
}

inline fun <L, R> Result<L, R>.onSuccess(fn: (success: R) -> Unit): Result<L, R> {
    return this.apply { if (this is Result.Success) fn.invoke(b) }
}