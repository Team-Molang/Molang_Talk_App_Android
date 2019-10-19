package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseRequest
import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.PostFilesResult

class PostFiles {
    data class Response(
        val url: String
    ): BaseResponse<PostFilesResult>() {
        override fun mapper(): PostFilesResult? {
            return PostFilesResult(
                url = url
            )
        }
    }
}