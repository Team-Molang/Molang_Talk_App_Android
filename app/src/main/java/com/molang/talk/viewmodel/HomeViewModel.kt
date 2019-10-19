package com.molang.talk.viewmodel

import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.MolangApplication
import com.molang.talk.common.extension.sharedPreference
import com.molang.talk.common.extension.toUserData
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.UserRepository
import com.molang.talk.common.util.PreferencesManager
import com.molang.talk.ui.common.sign.model.SignUpModel
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