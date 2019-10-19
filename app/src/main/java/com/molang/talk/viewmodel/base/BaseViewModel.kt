package com.molang.talk.viewmodel.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.molang.talk.common.extension.makeMessage
import com.molang.talk.common.util.MessageModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {
    protected val _displayMessage = MutableLiveData<MessageModel>()
    val displayMessage: LiveData<MessageModel>
        get() = _displayMessage

    val exceptionCoroutineScope = CoroutineExceptionHandler { _, throwable ->
        _displayMessage.postValue(makeMessage(throwable.localizedMessage ?: throwable.message ?: ""))
    }
}