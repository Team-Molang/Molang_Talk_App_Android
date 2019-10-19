package com.molang.talk.common.network.repository

import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.*
import com.molang.talk.common.network.result.GetPointHistoriesResult
import com.molang.talk.common.network.result.GetPointResult
import com.molang.talk.common.util.UserManager

class PointRepository(
    private val service: RetrofitService
) {
    suspend fun getPoint(): Result<GetPointResult>? {
        val response = service.getPointAsync(
            userId = UserManager.userId()
        ).await()
        return response.result()
    }

    suspend fun getPointHistories(): Result<MutableList<GetPointHistoriesResult>>? {

        val response = service.getPointHistoriesAsync(
            userId = UserManager.userId()
        ).await()
        return response.resultList()
    }
}