package com.molang.talk.common.extension

import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.navigation.NavController
import com.molang.talk.MainActivity
import com.molang.talk.ui.common.home.view.activity.HomeActivity

fun Context.startHome() {
    startActivity(Intent(this, HomeActivity::class.java))
}

infix fun NavController.to(@IdRes actionId: Int) {
    navigate(actionId)
}