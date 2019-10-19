package com.molang.talk.common.network.model

import com.google.gson.annotations.SerializedName
import com.molang.talk.common.network.BaseRequest
import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.PostUsersResult
import com.molang.talk.common.network.result.PutUsersResult

class PutUsers {
    data class Request(
        val nickName: String,
        val age: Int,
        val profile: String
    ): BaseRequest()

    class Response(
        val age: Int,
        val nickName: String,
        val profile: String?
    ): BaseResponse<PutUsersResult>() {
        override fun mapper(): PutUsersResult? {
            return PutUsersResult(
                age = age,
                profile = profile,
                nickName = nickName
            )
        }
    }
}