package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseRequest
import com.molang.talk.common.network.BaseResponse

class PostMatching {
    data class Request(
        val type: String = "EVERYONE",
        val userId: String = ""
    ): BaseRequest()
}