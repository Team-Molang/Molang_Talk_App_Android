package com.molang.talk.ui.home.view.fragment

import androidx.activity.OnBackPressedCallback
import androidx.databinding.ViewDataBinding
import com.molang.talk.ui.common.base.BaseFragment

abstract class BaseHomeFragment<BINDING: ViewDataBinding>: BaseFragment<BINDING>() {
    override fun initView() {
        activity?.onBackPressedDispatcher?.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })
    }

    open fun onBackPressed() {
        activity?.finish()
    }
}