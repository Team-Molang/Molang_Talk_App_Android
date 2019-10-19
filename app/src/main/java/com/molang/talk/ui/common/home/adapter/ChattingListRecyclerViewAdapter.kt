package com.molang.talk.ui.common.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.molang.talk.R
import com.molang.talk.common.extension.toInflate
import com.molang.talk.databinding.HolderChattingListBinding
import com.molang.talk.ui.common.base.BaseModel
import com.molang.talk.ui.common.base.BaseRecyclerViewAdapter
import com.molang.talk.ui.common.base.BaseViewHolder
import com.molang.talk.ui.common.chat.model.ChattingListModel
import com.molang.talk.ui.common.home.adapter.holder.ChattingListVH
import com.molang.talk.viewmodel.HomeViewModel

class ChattingListRecyclerViewAdapter : BaseRecyclerViewAdapter<ChattingListModel>() {
    override fun bindVH(holder: BaseViewHolder<*, *>, position: Int) {
        when(holder) {
            is ChattingListVH -> holder.bind(itemList[position])
        }
    }

    override fun createVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        return ChattingListVH(parent.toInflate(R.layout.holder_chatting_list))
    }
}