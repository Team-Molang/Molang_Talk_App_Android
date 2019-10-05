package com.molang.talk.ui.common.home.view.activity

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.molang.talk.R
import com.molang.talk.databinding.ActivityHomeBinding
import com.molang.talk.ui.common.base.BaseActivity

class HomeActivity: BaseActivity<ActivityHomeBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {

    }

    override fun setUp() {
    }

    override fun initListener() {
        binding.run {
            bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment))
        }
    }

}