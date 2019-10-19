package com.molang.talk.ui.common.profile.view.activity

import android.app.Activity
import android.content.Intent
import com.molang.talk.R
import com.molang.talk.common.constants.RequestCodeConstants
import com.molang.talk.common.extension.callGallery
import com.molang.talk.databinding.ActivityProfileSettingBinding
import com.molang.talk.ui.common.base.BaseActivity
import com.molang.talk.viewmodel.ProfileSettingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.molang.talk.MolangApplication
import com.molang.talk.common.extension.load
import com.molang.talk.common.extension.observe
import com.molang.talk.common.extension.toProfileModel
import com.molang.talk.common.util.UserData
import com.molang.talk.ui.common.profile.model.ProfileModel


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
        val userData = MolangApplication.userData
        if(userData == null) {
            viewModel.getUsers()
        } else {
            viewModel.setUserData(userData.toProfileModel())
        }
    }

    override fun setUp() {
        viewModel.run {
            observe(userData, Observer {
                drawUserUI(it)
            })
        }
    }

    override fun initListener() {
        binding.run {
            ivProfile.setOnClickListener {
                callGallery()
            }
            btnUpdateProfile.setOnClickListener {
                viewModel.putUsers()
            }
        }
    }

    private fun drawUserUI(userData: ProfileModel) {
        binding.run {
            etNickname.setText(userData.nickName)
            etAge.setText(userData.age.toString())
            ivProfile load userData.profile
        }
    }
}