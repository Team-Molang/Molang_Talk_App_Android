package com.molang.talk.common.network

import com.google.gson.Gson
import retrofit2.Response

sealed class Result<out T : Any>

data class Success<out T : Any>(val data: Any?) : Result<T>()
data class Failure(val error: Error?) : Result<Nothing>() {
    data class Error(
        val error: String?,
        var message: String?
    )
}

data class Except(val exception: Exception?) : Result<Nothing>()

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data as T)

    return this
}

inline fun <T : Any> Result<T>.onError(action: (Exception) -> Unit): Result<T> {
    if (this is Except && exception != null) action(exception)

    return this
}

inline fun <T : Any> Result<T>.onFailure(action: (Failure.Error) -> Unit): Result<T> {
    if (this is Failure && error != null) action(error)

    return this
}

inline fun <T : Any> Result<T>.onComplete(action: () -> Unit): Result<T> {
    action()
    return this
}


fun <B : BaseResponse<R>, R : Any> Response<B>.result(): Result<R>? {
    return try {
        if (this.isSuccessful) {
            Success(body()?.mapper())
        } else {
            val body = errorBody()?.source()?.buffer()?.clone()?.readUtf8()
            val error = Gson().fromJson<Failure.Error>(body, Failure.Error::class.java)
            Failure(error)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Except(NetworkException(isNetworkConnectionError = false))
    }
}


fun <B : BaseResponse<R>, R : Any> Response<List<B>>.resultList(): Result<MutableList<R>>? {
    return try {
        if (this.isSuccessful) {
            Success(body()?.map { it.mapper() }?.toMutableList())
        } else {
            val body = errorBody()?.source()?.buffer()?.clone()?.readUtf8()
            val error = Gson().fromJson<Failure.Error>(body, Failure.Error::class.java)
            Failure(error)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Except(NetworkException(isNetworkConnectionError = false))
    }
}
