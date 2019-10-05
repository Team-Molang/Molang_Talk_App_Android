package com.molang.talk.ui.common.home.view.fragment

import com.molang.talk.R
import com.molang.talk.databinding.FragmentHomeFindMatchingBinding
import com.molang.talk.ui.common.base.BaseFragment
import com.molang.talk.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFindMatchingFragment: BaseHomeFragment<FragmentHomeFindMatchingBinding>() {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun getLayoutId(): Int = R.layout.fragment_home_find_matching

    override fun initView() {
        super.initView()
    }

    override fun onBackPressed() {
        viewModel.setMatchingStatus(HomeViewModel.MatchingStatus.Normal)
    }

}