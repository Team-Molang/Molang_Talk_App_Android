package com.molang.talk.viewmodel.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    protected val _displayMessageResource = MutableLiveData<Int>()
    val displayMessageResource: LiveData<Int>
        get() = _displayMessageResource
}