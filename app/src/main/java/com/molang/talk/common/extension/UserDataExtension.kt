package com.molang.talk.common.extension

import com.molang.talk.MolangApplication
import com.molang.talk.common.network.result.GetUsersResult
import com.molang.talk.common.util.UserData
import com.molang.talk.ui.common.profile.model.ProfileModel

fun GetUsersResult.toUserData(): UserData {
    return UserData(
        nickName = nickName,
        regDate = regDate,
        profile = profile,
        point = point,
        gender = gender,
        age = age
    )
}

fun UserData.toProfileModel(): ProfileModel {
    return ProfileModel(
        nickName = nickName,
        regDate = regDate,
        profile = profile,
        point = point,
        gender = gender,
        age = age
    )
}