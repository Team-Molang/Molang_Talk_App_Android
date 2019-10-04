package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseRequest
import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.PostUsersResult

class PostUsers {
    data class Request(
        val udid: String,
        val nickName: String,
        val gender: String,
        val age: Int
    ): BaseRequest()

    data class Response(
        val udid: String
    ): BaseResponse<PostUsersResult>() {
        override fun mapper(): PostUsersResult? {
            return PostUsersResult(
                udid = udid
            )
        }
    }
}