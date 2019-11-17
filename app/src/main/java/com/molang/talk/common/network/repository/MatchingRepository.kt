package com.molang.talk.common.network.repository

import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.Result
import com.molang.talk.common.network.model.PostMatching
import com.molang.talk.common.network.result
import com.molang.talk.common.network.result.GetMatchingResult
import com.molang.talk.common.network.result.VoidResult
import com.molang.talk.common.util.UserManager

class MatchingRepository(
    private val service: RetrofitService
) {
    suspend fun postMatching(): Result<VoidResult>? {
        val model = PostMatching.Request(
            userId = UserManager.userId()
        )
        val response = service.postMatchingAsync(model).await()
        return response.result()
    }

    suspend fun getMatching(): Result<GetMatchingResult>? {
        val response = service.getMatchingAsync(
            userId = UserManager.userId()
        ).await()
        return response.result()
    }
}