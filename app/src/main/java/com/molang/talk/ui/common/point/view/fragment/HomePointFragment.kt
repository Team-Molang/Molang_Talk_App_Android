package com.molang.talk.ui.common.point.view.fragment

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.molang.talk.R
import com.molang.talk.databinding.FragmentHomePointBinding
import com.molang.talk.ui.common.chat.adapter.ChattingListRecyclerViewAdapter
import com.molang.talk.ui.common.chat.model.ChattingListModel
import com.molang.talk.ui.common.home.view.fragment.BaseHomeFragment
import com.molang.talk.ui.common.point.adapter.PointHistoryRecyclerViewAdapter
import com.molang.talk.ui.common.point.model.PointHistoryModel

class HomePointFragment: BaseHomeFragment<FragmentHomePointBinding>() {
    private val pointHistoryRecyclerViewAdapter: PointHistoryRecyclerViewAdapter by lazy {
        PointHistoryRecyclerViewAdapter()
    }

    override fun getLayoutId(): Int = R.layout.fragment_home_point

    override fun initView() {
        super.initView()
        binding.run {
            rvPointHistory.run {
                addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
                adapter = pointHistoryRecyclerViewAdapter
            }
        }

        pointHistoryRecyclerViewAdapter.setItemList(mutableListOf<PointHistoryModel>().apply {
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))
            add(PointHistoryModel(30, PointHistoryModel.State.Use))

        })
    }

}