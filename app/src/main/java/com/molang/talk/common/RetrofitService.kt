package com.molang.talk.common

import com.molang.talk.common.network.model.GetUsers
import com.molang.talk.common.network.model.PostFiles
import com.molang.talk.common.network.model.PostUsers
import com.molang.talk.common.network.model.PutUsers
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
     * 사용자 정보 조회
     */
    @GET("v1/users/{userId}")
    fun getUsersAsync(
        @Path("userId") userId: String
    ): Deferred<Response<GetUsers.Response>>

    /**
     * 사용자 정보 수정
     */
    @PUT("v1/users/{userId}")
    fun putUsersAsync(
        @Path("userId") userId: String,
        @Body model: PutUsers.Request
    ): Deferred<Response<PutUsers.Response>>

    /**
     * 파일 업로드
     */
    @Multipart
    @POST("v1/files")
    fun postFilesAsync(
        @Part file: MultipartBody.Part
    ): Deferred<Response<PostFiles.Response>>
}