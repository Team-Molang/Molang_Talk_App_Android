package com.molang.talk.common.network.model

import com.google.gson.annotations.SerializedName
import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.GetUsersResult

class GetUsers {
    data class Response(
        @SerializedName("id") val userId: Int,
        val nickName: String,
        val gender: String,
        val age: Int,
        val point: Int,
        val profile: String?,
        val regDate: String
    ): BaseResponse<GetUsersResult>() {
        override fun mapper(): GetUsersResult? {
            return GetUsersResult(
                userId = userId,
                nickName = nickName,
                age = age,
                gender = gender,
                point = point,
                profile = profile,
                regDate = regDate
            )
        }
    }
}