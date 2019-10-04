package com.molang.talk.common.network

abstract class BaseResponse<ITEM: Any> {
    abstract fun mapper(): ITEM?
}