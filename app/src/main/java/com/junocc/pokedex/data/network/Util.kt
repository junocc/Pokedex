package com.junocc.pokedex.data.network

import com.junocc.pokedex.domain.util.ResultError
import com.junocc.pokedex.domain.util.ResultType
import retrofit2.Response

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): ResultType<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                ResultType.Success(it)
            } ?: ResultType.Error(ResultError.Unknown(response.code(), "Empty body"))
        } else {
            val error = when (response.code()) {
                401 -> ResultError.Unauthorized
                404 -> ResultError.NotFound
                in 500..599 -> ResultError.ServerError
                else -> ResultError.Unknown(response.code(), response.message())
            }
            ResultType.Error(error)
        }
    } catch (e: Exception) {
        ResultType.Error(ResultError.Exception(e))
    }
}
