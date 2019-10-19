package com.molang.talk.common.extension

import android.widget.ImageView
import com.molang.talk.common.util.GlideApp

infix fun ImageView.load(url: String?) {
    GlideApp.with(this)
        .load(url)
        .into(this)
}