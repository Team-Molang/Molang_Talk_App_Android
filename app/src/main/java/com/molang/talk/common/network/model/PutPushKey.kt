package com.molang.talk.common.network.model

import com.molang.talk.common.network.BaseRequest
import com.molang.talk.common.network.BaseResponse
import com.molang.talk.common.network.result.PutUsersResult


class PutPushKey {
    data class Request(
        val key: String
    ): BaseRequest()
}