package com.molang.talk.ui.common.sign.view.fragment

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.molang.talk.R
import com.molang.talk.databinding.FragmentSignupGenderBinding
import com.molang.talk.ui.common.base.BaseFragment
import com.molang.talk.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpGenderFragment: BaseFragment<FragmentSignupGenderBinding>() {
    private val viewModel: SignUpViewModel by sharedViewModel()

    override fun getLayoutId(): Int = R.layout.fragment_signup_gender

    override fun initView() {
        initListener()
        setUp()

        binding.radioGroup.check(R.id.rb_gender_woman)
    }

    private fun setUp() {
        viewModel.run {
            gender.observe(this@SignUpGenderFragment, Observer {
                when(it) {
                    is SignUpViewModel.Gender.Man -> binding.radioGroup.check(R.id.rb_gender_man)
                    is SignUpViewModel.Gender.Woman -> binding.radioGroup.check(R.id.rb_gender_woman)
                }
            })
        }
    }

    private fun initListener() {
        binding.run {
            btnAction.setOnClickListener {
                val selectGender = if(radioGroup.checkedRadioButtonId == R.id.rb_gender_man) SignUpViewModel.Gender.Man()
                else SignUpViewModel.Gender.Woman()

                viewModel.setGender(selectGender)

                findNavController().navigate(R.id.action_from_gender_to_age)
            }
        }
    }
}