package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.BaseResponseList
import com.molang.talk.common.network.result.GetPointHistoriesResult

class GetPointHistories {
    class Response(
        val point: Int,
        val pointName: String,
        val regDate: String
    ) : BaseResponse<GetPointHistoriesResult>() {
        override fun mapper(): GetPointHistoriesResult? {
            return GetPointHistoriesResult(
                point = point,
                regDate = regDate,
                pointName = pointName
            )
        }
    }
}