package com.molang.talk.ui.common.profile

import android.app.Activity
import android.content.Intent
import com.molang.talk.R
import com.molang.talk.common.constants.RequestCodeConstants
import com.molang.talk.common.extension.callGallery
import com.molang.talk.databinding.ActivityProfileSettingBinding
import com.molang.talk.ui.common.base.BaseActivity
import com.molang.talk.viewmodel.ProfileSettingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.ParcelFileDescriptor
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileDescriptor


class ProfileSettingActivity : BaseActivity<ActivityProfileSettingBinding>() {

    private val viewModel: ProfileSettingViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_profile_setting

    private var saveUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                RequestCodeConstants.GALLERY -> {
                    data?.data?.let { uri ->
                        //                        contentResolver?.openOutputStream(uri, "w").use { outputStream ->
                        val byteArrayOutputStream = ByteArrayOutputStream()
                        getBitmapFromUri(uri)?.let { bitmap ->
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream)
                            byteArrayOutputStream.close()
                            val resizeInputStream = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
                            viewModel.postFile(resizeInputStream.readBytes())
                        }

                    }
//                    data?.data?.let { uri -> viewModel.postFile(uri) }
                }
                55 -> {
                    data?.data?.let { uri ->
                        contentResolver?.openOutputStream(uri, "w").use { outputStream ->
                            val bitmap = saveUri?.let { getBitmapFromUri(it) }
                            bitmap?.let { bitmap ->

                                //                                val resizeBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, true)
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream)
//                                bitmap.compress(Bitmap.CompressFormat.JPEG, 10, outputStream)
                                outputStream?.close()
                            }
                        }

//                        viewModel.postFile(uri)
                    }
                }
            }
        }
    }

    private fun createFile(fileName: String) {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/png"
            putExtra(Intent.EXTRA_TITLE, fileName)
        }

        startActivityForResult(intent, 55)
    }

    private fun getBitmapFromUri(uri: Uri): Bitmap? {
        val parcelFileDescriptor: ParcelFileDescriptor? =
            contentResolver.openFileDescriptor(uri, "r")
        val fileDescriptor: FileDescriptor? = parcelFileDescriptor?.fileDescriptor
        val image: Bitmap? = BitmapFactory.decodeFileDescriptor(fileDescriptor)
        parcelFileDescriptor?.close()
        return image
    }


    override fun initView() {

    }

    override fun setUp() {
    }

    override fun initListener() {
        binding.run {
            ivProfile.setOnClickListener {
                callGallery()
            }
        }
    }
}