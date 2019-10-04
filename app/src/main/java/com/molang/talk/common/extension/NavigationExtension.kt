package com.molang.talk.common.extension

import android.content.Context
import android.content.Intent
import com.molang.talk.MainActivity

fun Context.startMain() {
    startActivity(Intent(this, MainActivity::class.java))
}