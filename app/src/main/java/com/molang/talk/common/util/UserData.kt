package com.molang.talk.common.util

import com.molang.talk.common.network.result.GetUsersResult

data class UserData(
    val nickName: String,
    val gender: String,
    val age: Int,
    val point: Int,
    val profile: String?,
    val regDate: String
)