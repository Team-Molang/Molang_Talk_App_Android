package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.network.model.PutPushKey
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.AppRepository
import com.molang.talk.common.network.repository.MatchingRepository
import com.molang.talk.common.network.repository.UserRepository
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository,
    private val matchingRepository: MatchingRepository,
    private val appRepository: AppRepository
) : BaseViewModel() {

    sealed class MatchingStatus {
        object Find : MatchingStatus()
        object Normal : MatchingStatus()
    }

    protected val _matchingStatus = MutableLiveData<MatchingStatus>()
    val matchingStatus: LiveData<MatchingStatus>
        get() = _matchingStatus

    fun setMatchingStatus(status: MatchingStatus) {
        _matchingStatus.postValue(status)
    }

    fun getUser(action: () -> Unit) {
        viewModelScope.launch(exceptionCoroutineScope) {
            userRepository.getUsers()
                ?.onSuccess { action() }
        }
    }

    fun postMatching() {
        viewModelScope.launch(exceptionCoroutineScope) {
            matchingRepository.postMatching()
        }
    }

    fun putPushKey(pushKey: String) {
        viewModelScope.launch(exceptionCoroutineScope) {
            appRepository.putPushKey(pushKey)
        }
    }
}