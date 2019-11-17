package com.molang.talk.ui.splash.view.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.molang.talk.R
import com.molang.talk.common.extension.observe
import com.molang.talk.common.extension.startHome
import com.molang.talk.common.extension.startSignUp
import com.molang.talk.common.util.UserManager
import com.molang.talk.databinding.ActivitySplashBinding
import com.molang.talk.ui.common.base.BaseActivity
import com.molang.talk.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity<ActivitySplashBinding>() {

    private val viewModel: SplashViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initView() {
    }

    override fun setUp() {
        viewModel.run {
            observe(userStatus, Observer { result ->
                when(result) {
                    UserManager.UserStatus.Active -> {
                        startHome()
                        finish()
                    }
                    UserManager.UserStatus.Guest -> {
                        startSignUp()
                        finish()
                    }
                }
            })

            getAMS()
        }
    }

    override fun initListener() {
    }
}