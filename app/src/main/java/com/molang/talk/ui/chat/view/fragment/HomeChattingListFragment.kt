package com.molang.talk.ui.chat.view.fragment

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.molang.talk.R
import com.molang.talk.databinding.FragmentHomeChattingListBinding
import com.molang.talk.ui.chat.model.ChattingListModel
import com.molang.talk.ui.chat.adapter.ChattingListRecyclerViewAdapter
import com.molang.talk.ui.home.view.fragment.BaseHomeFragment

class HomeChattingListFragment: BaseHomeFragment<FragmentHomeChattingListBinding>() {

    private val chattingListRecyclerViewAdapter: ChattingListRecyclerViewAdapter by lazy {
        ChattingListRecyclerViewAdapter()
    }
    override fun getLayoutId(): Int = R.layout.fragment_home_chatting_list

    override fun initView() {
        super.initView()
        binding.run {
            rvChatList.run {
                addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
                adapter = chattingListRecyclerViewAdapter
            }
        }

        chattingListRecyclerViewAdapter.setItemList(mutableListOf<ChattingListModel>().apply {
            add(ChattingListModel("zzz", "asdasad"))
            add(ChattingListModel("zzz", "asdasad", isClose = true))
            add(ChattingListModel("zzz", "asdasad"))
            add(ChattingListModel("zzz", "asdasad"))
            add(ChattingListModel("zzz", "asdasad"))
            add(ChattingListModel("zzz", "asdasad"))
            add(ChattingListModel("zzz", "asdasad"))
        })
    }

    override fun setUp() {

    }
}