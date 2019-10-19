package com.molang.talk.ui.common.sign.view.fragment

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.molang.talk.R
import com.molang.talk.common.constants.Gender
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

    override fun setUp() {
        viewModel.run {
            model.observe(this@SignUpGenderFragment, Observer {
                when(it.gender) {
                    Gender.MAN.value -> binding.radioGroup.check(R.id.rb_gender_man)
                    Gender.WOMAN.value -> binding.radioGroup.check(R.id.rb_gender_woman)
                }
            })
        }
    }

    private fun initListener() {
        binding.run {
            btnAction.setOnClickListener {
                val selectGender = if(radioGroup.checkedRadioButtonId == R.id.rb_gender_man) Gender.MAN
                else Gender.WOMAN

                viewModel.setModelValue {
                    gender = selectGender.value
                }

                findNavController().navigate(R.id.action_from_gender_to_age)
            }
        }
    }
}