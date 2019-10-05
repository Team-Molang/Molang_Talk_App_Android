package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.molang.talk.ui.common.sign.model.SignUpModel
import com.molang.talk.viewmodel.base.BaseViewModel

class HomeViewModel: BaseViewModel() {

    sealed class MatchingStatus {
        object Find: MatchingStatus()
        object Normal: MatchingStatus()
    }

    protected val _matchingStatus = MutableLiveData<MatchingStatus>()
    val matchingStatus: LiveData<MatchingStatus>
        get() = _matchingStatus

    fun setMatchingStatus(status: MatchingStatus) {
        _matchingStatus.postValue(status)
    }
}