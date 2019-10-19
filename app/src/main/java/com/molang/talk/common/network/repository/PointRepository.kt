package com.molang.talk.common.network.repository

import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.*
import com.molang.talk.common.network.model.PostUsers
import com.molang.talk.common.network.result.GetPointHistoriesResult
import com.molang.talk.common.network.result.GetPointResult
import com.molang.talk.common.network.result.PostUsersResult
import com.molang.talk.common.util.UserManager
import com.molang.talk.ui.common.sign.model.SignUpModel
import java.util.*
import kotlin.coroutines.suspendCoroutine

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