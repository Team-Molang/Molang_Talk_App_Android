package com.molang.talk.common.network.result

data class GetAMSResult(
    val os: String,
    val version: String,
    val alert: String,
    val isAlert: Boolean,
    val isForceUpdate: Boolean
)