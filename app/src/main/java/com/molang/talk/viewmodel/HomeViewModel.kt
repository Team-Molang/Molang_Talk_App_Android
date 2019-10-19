package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.network.repository.UserRepository
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository
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

    fun getUser() {
        viewModelScope.launch(exceptionCoroutineScope) {
            userRepository.getUsers()
        }
    }
}