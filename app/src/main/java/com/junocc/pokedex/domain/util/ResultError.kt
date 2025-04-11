package com.junocc.pokedex.domain.util

sealed class ResultError {
    object Unauthorized : ResultError()
    object NotFound : ResultError()
    object ServerError : ResultError()
    data class Unknown(val code: Int, val message: String?) : ResultError()
    data class Exception(val throwable: Throwable) : ResultError()
}