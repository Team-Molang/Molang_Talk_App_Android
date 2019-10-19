package com.molang.talk.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.molang.talk.common.network.onSuccess
import com.molang.talk.common.network.repository.PointRepository
import com.molang.talk.ui.point.model.PointHistoryModel
import com.molang.talk.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch

class PointViewModel(
    private val pointRepository: PointRepository
) : BaseViewModel() {

    protected val _myPoint = MutableLiveData<Int>()
    val myPoint: LiveData<Int>
        get() = _myPoint

    protected val _pointHistories = MutableLiveData<MutableList<PointHistoryModel>>()
    val pointHistories: LiveData<MutableList<PointHistoryModel>>
        get() = _pointHistories

    fun onCreate() {
        getPoint()
        getPointHistories()
    }

    private fun getPoint() {
        viewModelScope.launch(exceptionCoroutineScope) {
            pointRepository.getPoint()
                ?.onSuccess { _myPoint.postValue(it.point) }
        }
    }

    private fun getPointHistories() {
        viewModelScope.launch(exceptionCoroutineScope) {
            pointRepository.getPointHistories()
                ?.onSuccess {
                    _pointHistories.postValue(it.map { data ->
                        PointHistoryModel(
                            point = data.point,
                            pointName = data.pointName,
                            regDate = data.regDate,
                            state = PointHistoryModel.State.Use
                        )
                    }.toMutableList())
                }
        }
    }
}