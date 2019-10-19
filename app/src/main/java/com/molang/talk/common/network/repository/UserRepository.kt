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
import com.molang.talk.ui.common.profile.model.ProfileModel
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

    suspend fun putUsers(profileModel: ProfileModel): Result<PutUsersResult>? {
        val model = PutUsers.Request(
            nickName = profileModel.nickName,
            age = profileModel.age,
            profile = profileModel.profile ?: ""
        )
        return try {
            val response = service.putUsersAsync(
                userId = UserManager.userId(),
                model = model
            ).await()
            response.result()
                ?.onSuccess { getUsers() }
        } catch (e: Exception) {
            e.printStackTrace()
            Except(NetworkException())
        }
    }

    suspend fun getUsers(): Result<GetUsersResult>? {
        return try {
            val response = service.getUsersAsync(
                userId = UserManager.userId()
            ).await()
            response.result()
                ?.onSuccess {
                    MolangApplication.userData = it.toUserData()
                }
        } catch (e: Exception) {
            e.printStackTrace()
            Except(NetworkException())
        }
    }
}