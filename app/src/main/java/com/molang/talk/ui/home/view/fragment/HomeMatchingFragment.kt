package com.molang.talk.ui.home.view.fragment

import com.molang.talk.R
import com.molang.talk.databinding.FragmentHomeMatchingBinding
import com.molang.talk.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeMatchingFragment : BaseHomeFragment<FragmentHomeMatchingBinding>() {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun getLayoutId(): Int = R.layout.fragment_home_matching

    override fun initView() {
        super.initView()
        initListener()
    }

    private fun initListener() {
        binding.run {
            btnDifferentSexMatching.setOnClickListener {
                viewModel.setMatchingStatus(HomeViewModel.MatchingStatus.Find)
            }
            btnRandomMatching.setOnClickListener {
                viewModel.postMatching()
            }
        }
    }

    override fun setUp() {

    }
}