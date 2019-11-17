package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.GetAMSResult

class GetAMS {
    data class Response(
        val os: String,
        val version: String,
        val alert: String,
        val isAlert: Boolean,
        val isForceUpdate: Boolean
    ): BaseResponse<GetAMSResult>() {
        override fun mapper(): GetAMSResult? {
            return GetAMSResult(
                os = os,
                alert = alert,
                isAlert = isAlert,
                isForceUpdate = isForceUpdate,
                version = version
            )
        }
    }
}