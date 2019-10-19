package com.molang.talk.common.network.result

import com.google.gson.annotations.SerializedName

data class GetUsersResult(
    val userId: Int,
    val nickName: String,
    val gender: String,
    val age: Int,
    val point: Int,
    val profile: String?,
    val regDate: String
)