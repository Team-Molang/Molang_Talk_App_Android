package com.molang.talk.common.network.repository

import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.Result
import com.molang.talk.common.network.model.PostMatching
import com.molang.talk.common.network.model.PutUsers
import com.molang.talk.common.network.result
import com.molang.talk.common.network.result.PostMathcingResult
import com.molang.talk.common.util.UserManager

class MatchingRepository(
    private val service: RetrofitService
) {
    suspend fun postMatching(): Result<PostMathcingResult>? {
        val model = PostMatching.Request(
            userId = UserManager.userId()
        )
        val response = service.postMatchingAsync(model).await()
        return response.result()
    }
}