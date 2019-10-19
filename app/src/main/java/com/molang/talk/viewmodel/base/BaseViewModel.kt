package com.molang.talk.viewmodel.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.molang.talk.common.util.MessageModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {
    protected val _displayMessage = MutableLiveData<MessageModel>()
    val displayMessage: LiveData<MessageModel>
        get() = _displayMessage

    val exceptionCoroutineScope = CoroutineExceptionHandler { _, throwable ->
        _displayMessage.postValue(makeMessage(throwable.localizedMessage ?: throwable.message ?: ""))
    }

    fun makeMessage(@StringRes resource: Int): MessageModel {
        return MessageModel.Resource(resource)
    }

    fun makeMessage(@StringRes resource: Int, vararg args: Any): MessageModel {
        return MessageModel.Resource(resource, *args)
    }

    fun makeMessage(message: String): MessageModel {
        return MessageModel.Normal(message)
    }
}