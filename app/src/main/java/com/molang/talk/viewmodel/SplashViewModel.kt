package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.network.onError
import com.molang.talk.common.network.onFailure
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.AppRepository
import com.molang.talk.common.util.UserManager
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(
    private val appRepository: AppRepository
): BaseViewModel() {


    protected val _userStatus = MutableLiveData<UserManager.UserStatus>()
    val userStatus: LiveData<UserManager.UserStatus>
        get() = _userStatus

    fun getAMS() {
        viewModelScope.launch(exceptionCoroutineScope) {
            appRepository.getAMS()
                ?.onSuccess {
                    checkUserIsActive()
                }
                ?.onFailure {
                    //NOTHING
                }
                ?.onError {
                    //NOTHING
                }
        }
    }

    private fun checkUserIsActive() {
        UserManager.status { status ->
            _userStatus.postValue(status)
        }
    }
}