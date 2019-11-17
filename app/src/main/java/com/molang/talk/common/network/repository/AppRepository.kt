package com.molang.talk.common.network.repository

import android.os.UserManager
import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.Result
import com.molang.talk.common.network.model.PutPushKey
import com.molang.talk.common.network.result
import com.molang.talk.common.network.result.GetAMSResult
import com.molang.talk.common.network.result.VoidResult

class AppRepository(
    private val service: RetrofitService
) {

    suspend fun getAMS(): Result<GetAMSResult>? {
        val response = service.getAMSAsync().await()
        return response.result()
    }

    suspend fun putPushKey(pushKey: String): Result<VoidResult>? {
        val model = PutPushKey.Request(
            key = pushKey
        )
        val response = service.putPushKeyAysnc(
            userId = com.molang.talk.common.util.UserManager.userId(),
            model = model
        ).await()

        return response.result()
    }
}