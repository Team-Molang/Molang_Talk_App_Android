package com.molang.talk.common.extension

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.DocumentsContract
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import com.molang.talk.MolangApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.*
import android.graphics.Bitmap
import android.util.Log
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import android.content.ContentValues
import android.content.ContentResolver
import android.provider.MediaStore
import android.provider.MediaStore.*
import android.provider.MediaStore.MediaColumns.*

fun Uri.toMultiPartBody(): MultipartBody.Part? {
    var result: MultipartBody.Part? = null
    MolangApplication.INSTANCE?.contentResolver?.openInputStream(this).use { stream ->
        stream?.let { inputStream ->
            //            val outputStream = ByteArrayOutputStream()
//            inputStream.use { input ->
//                outputStream.use { output ->
//                    input.copyTo(output)
//                }
//            }


//            val bmOptions = BitmapFactory.Options()
//            bmOptions.inJustDecodeBounds = true
//
            val byteArrayOutputStream = ByteArrayOutputStream()
//            BitmapFactory.decodeStream(ByteArrayInputStream(outputStream.toByteArray()), null, bmOptions)
//
//
//            bmOptions.inSampleSize = 2
//            bmOptions.inJustDecodeBounds = false

//            val bitmap = BitmapFactory.decodeStream(ByteArrayInputStream(outputStream.toByteArray()), null, bmOptions)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val resizeBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, true)
            resizeBitmap?.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)
            val resizeInputStream = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
            val requestFile = RequestBody.create(
                MediaType.parse("multipart/form-data"),
                resizeInputStream.readBytes()
            )
            result = MultipartBody.Part.createFormData(
                "file",
                "test.jpg",
                requestFile
            )
        }
    }
    return result
}

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