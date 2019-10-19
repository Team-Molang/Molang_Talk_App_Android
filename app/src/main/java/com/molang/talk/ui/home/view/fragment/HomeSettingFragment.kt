package com.molang.talk.ui.home.view.fragment

import com.molang.talk.R
import com.molang.talk.common.extension.startProfileSetting
import com.molang.talk.common.util.UserManager
import com.molang.talk.databinding.FragmentHomeSettingBinding

class HomeSettingFragment : BaseHomeFragment<FragmentHomeSettingBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home_setting

    override fun initView() {
        super.initView()
        initListener()
    }

    override fun setUp() {

    }

    private fun initListener() {
        binding.run {
            btnSettingProfile.setOnClickListener {
                startProfileSetting()
            }
            btnSettingLogout.setOnClickListener {
                UserManager.clear()
            }
        }
    }
}