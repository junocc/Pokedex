package com.junocc.pokedex.domain.util

sealed class ResultType<out T> {
    data class Success<out T>(val data: T) : ResultType<T>()
    data class Error(val error: ResultError) : ResultType<Nothing>()
}