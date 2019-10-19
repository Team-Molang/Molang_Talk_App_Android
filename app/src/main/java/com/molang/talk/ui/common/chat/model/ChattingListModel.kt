package com.molang.talk.ui.common.chat.model

import com.molang.talk.ui.common.base.BaseModel

data class ChattingListModel(
    val lastMessage: String,
    var isClose: Boolean = false
): BaseModel