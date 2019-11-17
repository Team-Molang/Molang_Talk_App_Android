package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.GetMatchingResult

class GetMatching {
    data class Response(
        val isMatching: Boolean
    ): BaseResponse<GetMatchingResult>() {
        override fun mapper(): GetMatchingResult? {
            return GetMatchingResult(
                isMatching = isMatching
            )
        }
    }
}