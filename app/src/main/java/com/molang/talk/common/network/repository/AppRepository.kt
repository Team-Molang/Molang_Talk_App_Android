package com.molang.talk.common.network.repository

import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.Result
import com.molang.talk.common.network.result
import com.molang.talk.common.network.result.GetAMSResult

class AppRepository(
    private val service: RetrofitService
) {

    suspend fun getAMS(): Result<GetAMSResult>? {
        val response = service.getAMSAsync().await()
        return response.result()
    }
}