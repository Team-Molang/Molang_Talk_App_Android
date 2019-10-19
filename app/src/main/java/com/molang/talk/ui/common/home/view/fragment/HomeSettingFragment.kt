package com.molang.talk.ui.common.home.view.fragment

import com.molang.talk.R
import com.molang.talk.common.extension.sharedPreference
import com.molang.talk.common.extension.startProfileSetting
import com.molang.talk.common.util.UserManager
import com.molang.talk.databinding.FragmentHomeSettingBinding
import com.molang.talk.ui.common.base.BaseFragment

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