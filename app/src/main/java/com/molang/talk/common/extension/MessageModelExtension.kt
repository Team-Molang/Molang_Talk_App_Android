package com.molang.talk.common.extension

import android.content.Context
import com.molang.talk.common.util.MessageModel

fun MessageModel.getString(context: Context): String {
    return when (this) {
        is MessageModel.Normal -> message
        is MessageModel.Resource -> {
            if (argument.isNotEmpty()) {
                context.getString(resource, *argument)
            } else {
                context.getString(resource)
            }
        }
    }
}