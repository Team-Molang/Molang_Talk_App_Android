package com.molang.talk.ui.sign.view.fragment

import com.molang.talk.R
import com.molang.talk.databinding.FragmentSignupAgeBinding
import com.molang.talk.ui.common.base.BaseFragment
import androidx.lifecycle.Observer
import com.molang.talk.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SignUpAgeFragment: BaseFragment<FragmentSignupAgeBinding>() {

    private val viewModel: SignUpViewModel by sharedViewModel()

    override fun getLayoutId(): Int = R.layout.fragment_signup_age

    override fun initView() {
        initListener()
        setUp()
    }

    override fun setUp() {
        viewModel.run {
            model.observe(this@SignUpAgeFragment, Observer {
                binding.etAge.setText(it.age.toString())
            })
        }
    }

    private fun initListener() {
        binding.run {
            btnAction.setOnClickListener {
                viewModel.postUser()
            }
        }
    }

}