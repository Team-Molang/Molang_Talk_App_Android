package com.molang.talk.common.extension

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.ifShow(action: () -> Boolean) {
    if(action()) show()
    else hide()
}