package com.molang.talk.ui.common.home.view.fragment

import com.molang.talk.R
import com.molang.talk.databinding.FragmentHomeSettingBinding
import com.molang.talk.ui.common.base.BaseFragment

class HomeSettingFragment : BaseHomeFragment<FragmentHomeSettingBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_home_setting

    override fun initView() {
        super.initView()
        initListener()
    }

    private fun initListener() {
        binding.run {
        }
    }
}