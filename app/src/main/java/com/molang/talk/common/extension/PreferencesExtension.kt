package com.molang.talk.common.extension

import android.content.SharedPreferences
import androidx.core.content.edit
import com.molang.talk.common.util.PreferencesManager

fun sharedPreference(): SharedPreferences? {
    return PreferencesManager.get()
}