package com.molang.talk.common.network.repository

import com.molang.talk.MolangApplication
import com.molang.talk.common.RetrofitService
import com.molang.talk.common.extension.toUserData
import com.molang.talk.common.network.*
import com.molang.talk.common.network.model.PostUsers
import com.molang.talk.common.network.model.PutUsers
import com.molang.talk.common.network.result.GetUsersResult
import com.molang.talk.common.network.result.PostUsersResult
import com.molang.talk.common.network.result.PutUsersResult
import com.molang.talk.common.util.UserManager
import com.molang.talk.ui.profile.model.ProfileModel
import com.molang.talk.ui.sign.model.SignUpModel
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
        val response = service.postUsersAsync(
            model = model
        ).await()
        return response.result()
    }

    suspend fun putUsers(profileModel: ProfileModel): Result<PutUsersResult>? {
        val model = PutUsers.Request(
            nickName = profileModel.nickName,
            age = profileModel.age,
            profile = profileModel.profile ?: ""
        )
        val response = service.putUsersAsync(
            userId = UserManager.userId(),
            model = model
        ).await()
        return response.result()
            ?.onSuccess { getUsers() }
    }

    suspend fun getUsers(): Result<GetUsersResult>? {
        val response = service.getUsersAsync(
            userId = UserManager.userId()
        ).await()
        return response.result()
            ?.onSuccess {
                MolangApplication.userData = it.toUserData()
            }
    }
}