package com.molang.talk.ui.sign.view.activity

import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.molang.talk.R
import com.molang.talk.common.extension.observe
import com.molang.talk.common.extension.startHome
import com.molang.talk.common.util.UserManager
import com.molang.talk.databinding.ActivitySignupBinding
import com.molang.talk.ui.common.base.BaseActivity
import com.molang.talk.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity: BaseActivity<ActivitySignupBinding>() {
    private val viewModel: SignUpViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_signup

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    override fun initView() {
        binding.run {
            setSupportActionBar(toolbar)
            NavigationUI.setupActionBarWithNavController(this@SignUpActivity, findNavController(R.id.nav_host_fragment))
        }
    }

    override fun onStart() {
        super.onStart()
        UserManager.authorization()?.let { authorization ->
            if(authorization.isNotEmpty()) viewModel.setSignUpStatus(SignUpViewModel.SignUpStatus.Success)
        }
    }

    override fun setUp() {
        viewModel.run {
            observe(signUpStatus, Observer { result ->
                when(result) {
                    SignUpViewModel.SignUpStatus.Success -> {
                        startHome()
                        finish()
                    }
                }
            })
        }
    }

    override fun initListener() {

    }
}