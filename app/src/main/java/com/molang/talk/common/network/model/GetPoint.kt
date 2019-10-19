package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.GetPointResult

class GetPoint {
    data class Response(
        val point: Int
    ): BaseResponse<GetPointResult>() {
        override fun mapper(): GetPointResult? {
            return GetPointResult(
                point = point
            )
        }
    }
}