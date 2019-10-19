package com.molang.talk.common.network.result

data class GetPointHistoriesResult(
    val point: Int,
    val pointName: String,
    val regDate: String
)