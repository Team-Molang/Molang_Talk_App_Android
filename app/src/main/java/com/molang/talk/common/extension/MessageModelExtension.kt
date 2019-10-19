package com.molang.talk.common.extension

import android.content.Context
import androidx.annotation.StringRes
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

fun makeMessage(@StringRes resource: Int): MessageModel {
    return MessageModel.Resource(resource)
}

fun makeMessage(@StringRes resource: Int, vararg args: Any): MessageModel {
    return MessageModel.Resource(resource, *args)
}

fun makeMessage(message: String): MessageModel {
    return MessageModel.Normal(message)
}