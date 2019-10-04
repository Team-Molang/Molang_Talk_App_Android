package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.constants.Gender
import com.molang.talk.common.network.onError
import com.molang.talk.common.network.onFailure
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.UserRepository
import com.molang.talk.ui.common.sign.model.SignUpModel
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val userRepository: UserRepository
) : BaseViewModel() {

    protected val _model = MutableLiveData<SignUpModel>()
    val model: LiveData<SignUpModel>
        get() = _model

    fun setModelValue(init: SignUpModel.() -> Unit) {
        _model.postValue((_model.value ?: SignUpModel()).apply(init))
    }

    fun postUser() {
        _model.value?.let {
            viewModelScope.launch {
                userRepository.postUsers(it)
                    ?.onSuccess { }
                    ?.onFailure { }
                    ?.onError { }
            }
        }
    }

}