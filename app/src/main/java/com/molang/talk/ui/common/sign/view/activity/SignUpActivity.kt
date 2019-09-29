package com.molang.talk.ui.common.sign.view.activity

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.molang.talk.R
import com.molang.talk.databinding.ActivitySignupBinding
import com.molang.talk.ui.common.base.BaseActivity

class SignUpActivity: BaseActivity<ActivitySignupBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_signup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onSupportNavigateUp(): Boolean {
        // Allows NavigationUI to support proper up navigation or the drawer layouCt
        // drawer menu, depending on the situation
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    private fun initView() {
        binding.run {
            setSupportActionBar(toolbar)
            NavigationUI.setupActionBarWithNavController(this@SignUpActivity, findNavController(R.id.nav_host_fragment))
        }
    }
}