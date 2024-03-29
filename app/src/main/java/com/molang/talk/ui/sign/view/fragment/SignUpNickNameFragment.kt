package com.molang.talk.ui.sign.view.fragment

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
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

    override fun setUp() {
        viewModel.run {
            model.observe(this@SignUpNickNameFragment, Observer {
                binding.etNickname.setText(it.nickName)
            })
        }
    }

    private fun initListener() {
        binding.run {
            btnAction.setOnClickListener {
                viewModel.setModelValue {
                    nickName = etNickname.text.toString()
                }
                findNavController().navigate(R.id.action_from_nickname_to_gender)
            }
        }
    }

}