package com.molang.talk.ui.common.point.model

import com.molang.talk.ui.common.base.BaseModel

data class PointHistoryModel(
    val point: Int,
    val state: State
): BaseModel {
    sealed class State {
        object Charge: State()
        object Use: State()
    }
}