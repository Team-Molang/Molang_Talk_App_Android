package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseRequest
import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.PostMathcingResult

class PostMatching {
    data class Request(
        val type: String = "EVERYONE",
        val userId: String = ""
    ): BaseRequest()

    class Response : BaseResponse<PostMathcingResult>() {
        override fun mapper(): PostMathcingResult? {
            return PostMathcingResult()
        }
    }
}