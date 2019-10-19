package com.molang.talk.ui.common.chat.view.fragment

import com.molang.talk.R
import com.molang.talk.databinding.FragmentHomeChattingBinding
import com.molang.talk.ui.common.chat.model.ChattingListModel
import com.molang.talk.ui.common.home.adapter.ChattingListRecyclerViewAdapter
import com.molang.talk.ui.common.home.view.fragment.BaseHomeFragment

class HomeChattingListFragment: BaseHomeFragment<FragmentHomeChattingBinding>() {
    private val chattingListRecyclerViewAdapter: ChattingListRecyclerViewAdapter by lazy {
        ChattingListRecyclerViewAdapter()
    }
    override fun getLayoutId(): Int = R.layout.fragment_home_chatting

    override fun initView() {
        super.initView()
        binding.run {
            rvChatList.adapter = chattingListRecyclerViewAdapter
        }

        chattingListRecyclerViewAdapter.setItemList(mutableListOf<ChattingListModel>().apply {
            add(ChattingListModel("asdasad"))
            add(ChattingListModel("asdasad", isClose = true))
            add(ChattingListModel("asdasad"))
            add(ChattingListModel("asdasad"))
            add(ChattingListModel("asdasad"))
            add(ChattingListModel("asdasad"))
            add(ChattingListModel("asdasad"))
        })
    }

}