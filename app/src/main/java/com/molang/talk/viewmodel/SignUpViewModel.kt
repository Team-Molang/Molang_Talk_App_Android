package com.molang.talk.viewmodel

import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.extension.sharedPreference
import com.molang.talk.common.network.onError
import com.molang.talk.common.network.onFailure
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.UserRepository
import com.molang.talk.common.util.PreferencesManager
import com.molang.talk.ui.sign.model.SignUpModel
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val userRepository: UserRepository
) : BaseViewModel() {

    sealed class SignUpStatus {
        object Success: SignUpStatus()
    }

    protected val _model = MutableLiveData<SignUpModel>()
    val model: LiveData<SignUpModel>
        get() = _model

    protected val _signUpStatus = MutableLiveData<SignUpStatus>()
    val signUpStatus: LiveData<SignUpStatus>
        get() = _signUpStatus

    fun setModelValue(init: SignUpModel.() -> Unit) {
        _model.postValue((_model.value ?: SignUpModel()).apply(init))
    }


    fun postUser() {
        _model.value?.let {
            viewModelScope.launch(exceptionCoroutineScope) {
                userRepository.postUsers(it)
                    ?.onSuccess {
                        sharedPreference()?.edit {
                            putString(PreferencesManager.PREF_KEY_USER_ID, it.userId.toString())
                            putString(PreferencesManager.PREF_KEY_AUTHORIZATION, it.authorization)
                        }

                        _signUpStatus.postValue(SignUpStatus.Success)
                    }

                    ?.onFailure { }
                    ?.onError { }
            }
        }
    }

}