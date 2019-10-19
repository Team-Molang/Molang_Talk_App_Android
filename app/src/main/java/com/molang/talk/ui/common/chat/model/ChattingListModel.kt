package com.molang.talk.ui.common.chat.model

import com.molang.talk.ui.common.base.BaseModel

data class ChattingListModel(
    val nickName: String,
    val lastMessage: String,
    var isClose: Boolean = false,
    val profile: String? = "https://image.fmkorea.com/files/attach/new/20190726/3655299/986691455/2026681871/0b862a3363f4beedfc7dd8efcd5efffa.jpg"
): BaseModel