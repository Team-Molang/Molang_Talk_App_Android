package com.molang.talk.common.network.model.base

import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.VoidResult

class VoidResponse: BaseResponse<VoidResult>() {
    override fun mapper(): VoidResult? {
        return VoidResult()
    }
}