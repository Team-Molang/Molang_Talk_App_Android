package com.molang.talk.common.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun<T> LifecycleOwner.observe(data: LiveData<T>, observer: Observer<T>) {
    data.observe(this, observer)
}