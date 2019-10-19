package com.molang.talk.common.network.repository

import android.net.Uri
import com.molang.talk.common.RetrofitService
import com.molang.talk.common.extension.toMultiPartBody
import com.molang.talk.common.extension.toRequestBody
import com.molang.talk.common.network.Except
import com.molang.talk.common.network.NetworkException
import com.molang.talk.common.network.Result
import com.molang.talk.common.network.model.PostFiles
import com.molang.talk.common.network.result
import com.molang.talk.common.network.result.PostFilesResult
import java.net.URI

class FileRepository(
    private val service: RetrofitService
) {
    suspend fun postFiles(bitmapByteArray: ByteArray): Result<PostFilesResult>? {
        return try {
            val response = bitmapByteArray.toMultiPartBody()?.let {
                service.postFilesAsync(
                    file = it
                ).await()
            }
            response?.result()
        } catch (e: Exception) {
            e.printStackTrace()
            Except(NetworkException())
        }
    }
}