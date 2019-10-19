package com.molang.talk.common.util

import androidx.annotation.StringRes

sealed class MessageModel {
    class Resource(
        @StringRes var resource: Int,
        vararg var argument: Any? = arrayOf()
    ): MessageModel()
    class Normal(
        val message: String
    ): MessageModel()
}


