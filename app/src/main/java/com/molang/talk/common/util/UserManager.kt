package com.molang.talk.common.util

import com.molang.talk.common.extension.sharedPreference

object UserManager {
    fun UDID(): String? {
        return sharedPreference()?.getString(PreferencesManager.PREF_KEY_UDID, null)
    }
}