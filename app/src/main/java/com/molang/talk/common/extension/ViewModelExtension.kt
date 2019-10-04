package com.molang.talk.common.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun LifecycleOwner.observe(data: LiveData<*>, observer: Observer<Any>) {
    data.observe(this, observer)
}