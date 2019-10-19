package com.molang.talk.common.extension

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.ParcelFileDescriptor
import com.molang.talk.MolangApplication
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileDescriptor

fun Uri.resizeBitmapToInputStream(): ByteArray? {
    val byteArrayOutputStream = ByteArrayOutputStream()
    getBitmapFromUri(this)?.let { bitmap ->
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream)
        byteArrayOutputStream.close()
        val resizeInputStream = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
        return resizeInputStream.readBytes()
    } ?: return null
}

private fun getBitmapFromUri(uri: Uri): Bitmap? {
    val parcelFileDescriptor: ParcelFileDescriptor? =
        MolangApplication.INSTANCE?.contentResolver?.openFileDescriptor(uri, "r")
    val fileDescriptor: FileDescriptor? = parcelFileDescriptor?.fileDescriptor
    val image: Bitmap? = BitmapFactory.decodeFileDescriptor(fileDescriptor)
    parcelFileDescriptor?.close()
    return image
}