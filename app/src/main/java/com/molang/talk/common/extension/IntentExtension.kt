package com.molang.talk.common.extension

import android.app.Activity
import androidx.core.app.ActivityCompat.startActivityForResult
import android.content.Intent
import com.molang.talk.common.constants.RequestCodeConstants


fun Activity.callGallery() {
    startActivityForResult(Intent().apply {
        type = "image/*"
        action = Intent.ACTION_GET_CONTENT
        flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
    }, RequestCodeConstants.GALLERY)
}