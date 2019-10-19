package com.molang.talk.common.util

import androidx.core.content.edit
import com.molang.talk.common.extension.sharedPreference

object UserManager {
    fun userId(): Int? {
        return sharedPreference()?.getInt(PreferencesManager.PREF_KEY_USER_ID, -1)
    }

    fun authorization(): String? {
        return sharedPreference()?.getString(PreferencesManager.PREF_KEY_AUTHORIZATION, null)
    }

    fun clear() {
        sharedPreference()?.edit {
            remove(PreferencesManager.PREF_KEY_USER_ID)
            remove(PreferencesManager.PREF_KEY_AUTHORIZATION)
        }
    }
}