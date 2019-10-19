package com.molang.talk.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.extension.resizeBitmapToInputStream
import com.molang.talk.common.extension.toProfileModel
import com.molang.talk.common.extension.toUserData
import com.molang.talk.common.network.onError
import com.molang.talk.common.network.onFailure
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.FileRepository
import com.molang.talk.common.network.repository.UserRepository
import com.molang.talk.ui.profile.model.ProfileModel
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class ProfileSettingViewModel(
    private val fileRepository: FileRepository,
    private val userRepository: UserRepository
) : BaseViewModel() {

    protected val _userData = MutableLiveData<ProfileModel>()
    val userData: LiveData<ProfileModel>
        get() = _userData


    fun setUserData(data: ProfileModel) {
        _userData.postValue(data)
    }

    fun setUserValue(init: ProfileModel.() -> Unit) {
        _userData.value?.apply(init)?.let {
            setUserData(it)
        }
    }

    fun postFile(bitmapUri: Uri) {
        viewModelScope.launch(exceptionCoroutineScope) {
            bitmapUri.resizeBitmapToInputStream()?.let {
                fileRepository.postFiles(
                    bitmapByteArray = it
                )
                    ?.onSuccess {
                        setUserValue {
                            profile = it.url
                        }
                    }
                    ?.onFailure { }
                    ?.onError { }
            }
        }
    }

    fun getUsers() {
        viewModelScope.launch(exceptionCoroutineScope) {
            userRepository.getUsers()
                ?.onSuccess { setUserData(it.toUserData().toProfileModel()) }
        }
    }

    fun putUsers() {
        _userData.value?.let { model ->
            viewModelScope.launch(exceptionCoroutineScope) {
                userRepository.putUsers(model)
            }
        }
    }
}