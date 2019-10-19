package com.molang.talk.common.network

abstract class BaseResponseList<ITEM: Any> {
    abstract fun mapper(): MutableList<ITEM?>
}