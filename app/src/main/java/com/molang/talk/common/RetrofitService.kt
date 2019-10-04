package com.molang.talk.common

import com.molang.talk.common.network.model.PostUsers
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    /**
     * 시작하기
     */
    @POST("v1/users")
    fun postUsersAsync(@Body model: PostUsers.Request): Deferred<Response<PostUsers.Response>>
}