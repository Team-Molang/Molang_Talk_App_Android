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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                RequestCodeConstants.GALLERY -> {
                    data?.data?.let { uri ->
                        viewModel.postFile(uri)
                    }
                }
            }
        }
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