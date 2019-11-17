package com.molang.talk.common.util

import androidx.core.content.edit
import com.molang.talk.common.extension.sharedPreference

object UserManager {

    sealed class UserStatus {
        object Active: UserStatus()
        object Guest: UserStatus()
    }

    fun userId(): String {
        return sharedPreference()?.getString(PreferencesManager.PREF_KEY_USER_ID, null) ?: ""
    }

    fun authorization(): String? {
        return sharedPreference()?.getString(PreferencesManager.PREF_KEY_AUTHORIZATION, null)
    }

    fun status(action: (UserStatus) -> Unit) {
        val authorization = authorization()
        if(authorization.isNullOrEmpty()) action(UserStatus.Guest)
        else action(UserStatus.Active)
    }

    fun clear() {
        sharedPreference()?.edit {
            remove(PreferencesManager.PREF_KEY_USER_ID)
            remove(PreferencesManager.PREF_KEY_AUTHORIZATION)
        }
    }
}