package com.molang.talk.ui.common.point.view.fragment

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.molang.talk.R
import com.molang.talk.common.extension.getString
import com.molang.talk.common.extension.makeMessage
import com.molang.talk.common.extension.observe
import com.molang.talk.databinding.FragmentHomePointBinding
import com.molang.talk.ui.common.home.view.fragment.BaseHomeFragment
import com.molang.talk.ui.common.point.adapter.PointHistoryRecyclerViewAdapter
import com.molang.talk.ui.common.point.model.PointHistoryModel
import com.molang.talk.viewmodel.PointViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomePointFragment: BaseHomeFragment<FragmentHomePointBinding>() {

    private val pointHistoryRecyclerViewAdapter: PointHistoryRecyclerViewAdapter by lazy {
        PointHistoryRecyclerViewAdapter()
    }

    private val viewModel: PointViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_home_point

    override fun initView() {
        super.initView()
        binding.run {
            rvPointHistory.run {
                addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
                adapter = pointHistoryRecyclerViewAdapter
            }
        }
    }

    override fun setUp() {
        viewModel.run {
            observe(displayMessage, Observer {
            })
            observe(pointHistories, Observer {
                pointHistoryRecyclerViewAdapter.setItemList(it)
            })
            observe(myPoint, Observer {
                binding.tvMyPoint.text = makeMessage(R.string.home_point_my_point_formatter, it).getString(requireContext())
            })
        }

        viewModel.onCreate()
    }


}