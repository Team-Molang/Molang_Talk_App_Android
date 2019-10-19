package com.molang.talk.common.extension

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

fun ByteArray.toMultiPartBody(): MultipartBody.Part? {
    val requestFile = RequestBody.create(
        MediaType.parse("multipart/form-data"),
        this
    )
    return MultipartBody.Part.createFormData(
        "file",
        "test.jpg",
        requestFile
    )
}

fun String.toRequestBody(): RequestBody {
    return RequestBody.create(MediaType.parse("multipart/form-data"), this)
}