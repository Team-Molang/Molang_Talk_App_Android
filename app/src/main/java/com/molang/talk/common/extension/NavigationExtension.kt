package com.molang.talk.common.extension

import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.molang.talk.ui.home.view.activity.HomeActivity
import com.molang.talk.ui.profile.view.activity.ProfileSettingActivity
import com.molang.talk.ui.sign.view.activity.SignUpActivity

fun Context.startHome() {
    startActivity(Intent(this, HomeActivity::class.java))
}

fun Context.startProfileSetting() {
    startActivity(Intent(this, ProfileSettingActivity::class.java))
}

fun Fragment.startProfileSetting() {
    startActivity(Intent(requireContext(), ProfileSettingActivity::class.java))
}

fun Context.startSignUp() {
    startActivity(Intent(this, SignUpActivity::class.java))
}


infix fun NavController.to(@IdRes actionId: Int) {
    navigate(actionId)
}