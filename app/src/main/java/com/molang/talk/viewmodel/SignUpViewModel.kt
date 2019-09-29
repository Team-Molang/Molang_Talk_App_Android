package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.molang.talk.viewmodel.base.BaseViewModel

class SignUpViewModel: BaseViewModel() {

    sealed class Gender(val value: String) {
        class Woman : Gender("W")
        class Man : Gender("M")
    }

    protected val _nickName = MutableLiveData<String>()
    val nickName: LiveData<String>
        get() = _nickName

    protected val _age = MutableLiveData<Int>()
    val age: LiveData<Int>
        get() = _age

    protected val _gender = MutableLiveData<Gender>()
    val gender: LiveData<Gender>
        get() = _gender

    fun setNickName(nickName: String) {
        _nickName.postValue(nickName)
    }

    fun setGender(gender: Gender) {
        _gender.postValue(gender)
    }

    fun setAge(age: Int) {
        _age.postValue(age)
    }


}