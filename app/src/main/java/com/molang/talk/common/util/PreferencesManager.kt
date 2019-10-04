package com.molang.talk.common.util

import android.app.Activity
import android.content.SharedPreferences
import com.molang.talk.MolangApplication


object PreferencesManager {
    private const val PREF_PACKAGE_NAME = "com.molang.talk.preferences"

    const val PREF_KEY_UDID = "$PREF_PACKAGE_NAME.udid"

    fun get(): SharedPreferences? {
        return MolangApplication.INSTANCE?.getSharedPreferences(PREF_PACKAGE_NAME, Activity.MODE_PRIVATE)
    }
}
