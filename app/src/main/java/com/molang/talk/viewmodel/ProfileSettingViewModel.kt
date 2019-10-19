package com.molang.talk.viewmodel

import androidx.lifecycle.viewModelScope
import com.molang.talk.common.network.onError
import com.molang.talk.common.network.onFailure
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.FileRepository
import com.molang.talk.common.util.UserManager
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class ProfileSettingViewModel(
    private val fileRepository: FileRepository
) : BaseViewModel() {

    fun postFile(bitmapByteArray: ByteArray) {
        viewModelScope.launch {
            fileRepository.postFiles(
                bitmapByteArray = bitmapByteArray
            )
                ?.onSuccess {

                }
                ?.onFailure { }
                ?.onError { }
        }
    }
}