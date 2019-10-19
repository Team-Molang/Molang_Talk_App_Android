package com.molang.talk.common

import com.molang.talk.common.network.model.PostFiles
import com.molang.talk.common.network.model.PostUsers
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    /**
     * 시작하기
     */
    @POST("v1/users")
    fun postUsersAsync(
        @Body model: PostUsers.Request
    ): Deferred<Response<PostUsers.Response>>

    /**
     * 파일 업로드
     */
    @Multipart
    @POST("v1/files")
    fun postFilesAsync(
        @Part("udid") udid: RequestBody,
        @Part file: MultipartBody.Part
    ): Deferred<Response<PostFiles.Response>>
}