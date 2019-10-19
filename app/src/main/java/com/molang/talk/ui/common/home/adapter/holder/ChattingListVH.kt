package com.molang.talk.ui.common.home.adapter.holder

import com.molang.talk.common.extension.ifShow
import com.molang.talk.common.extension.load
import com.molang.talk.common.extension.show
import com.molang.talk.databinding.HolderChattingListBinding
import com.molang.talk.ui.common.base.BaseViewHolder
import com.molang.talk.ui.common.chat.model.ChattingListModel

class ChattingListVH(b: HolderChattingListBinding) :
    BaseViewHolder<HolderChattingListBinding, ChattingListModel>(b) {
    override fun bind(model: ChattingListModel) {
        binding.data = model
        checkCloseChatting(model.isClose)
        loadProfile(model.profile)
    }

    fun checkCloseChatting(isClose: Boolean) {
        binding.dim.ifShow { isClose }
    }

    fun loadProfile(profile: String?) {
        binding.ivProfile load profile
    }
}