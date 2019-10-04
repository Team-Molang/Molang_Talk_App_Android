package com.molang.talk.common.network

class NetworkException(
    var isNetworkConnectionError: Boolean = true
) : Exception(
    if (isNetworkConnectionError) "네트워크를 확인해 주세요!"
    else "서버가 아파요.. 잠시 후 다시 시도해주세요!"
) {

}