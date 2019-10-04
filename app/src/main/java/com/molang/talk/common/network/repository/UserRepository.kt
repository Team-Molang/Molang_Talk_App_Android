package com.molang.talk.common.network.repository

import com.molang.talk.common.RetrofitService
import com.molang.talk.common.network.Except
import com.molang.talk.common.network.NetworkException
import com.molang.talk.common.network.Result
import com.molang.talk.common.network.model.PostUsers
import com.molang.talk.common.network.result
import com.molang.talk.common.network.result.PostUsersResult
import com.molang.talk.ui.common.sign.model.SignUpModel
import java.util.*

class UserRepository(
    private val service: RetrofitService
) {
    suspend fun postUsers(signUpModel: SignUpModel): Result<PostUsersResult>? {
        val model = PostUsers.Request(
            udid = UUID.randomUUID().toString(),
            nickName = signUpModel.nickName,
            gender = signUpModel.gender,
            age = signUpModel.age
        )
        return try {
            val response = service.postUsersAsync(
                model = model
            ).await()
            response.result()
        } catch (e: Exception) {
            e.printStackTrace()
            Except(NetworkException())
        }
    }
}