package com.molang.talk.ui.common.sign.view.fragment

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.molang.talk.R
import com.molang.talk.databinding.FragmentSignupNicknameBinding
import com.molang.talk.ui.common.base.BaseFragment
import com.molang.talk.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpNickNameFragment: BaseFragment<FragmentSignupNicknameBinding>() {
    private val viewModel: SignUpViewModel by sharedViewModel()

    override fun getLayoutId(): Int = R.layout.fragment_signup_nickname

    override fun initView() {
        initListener()
        setUp()
    }

    private fun setUp() {
        viewModel.run {
            nickName.observe(this@SignUpNickNameFragment, Observer {
                binding.etNickname.setText(it)
            })
        }
    }

    private fun initListener() {
        binding.run {
            btnAction.setOnClickListener {
                viewModel.setNickName(etNickname.text.toString())
                findNavController().navigate(R.id.action_from_nickname_to_gender)
            }
        }
    }

}