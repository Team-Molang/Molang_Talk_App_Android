package com.molang.talk.ui.point.adapter

import android.view.ViewGroup
import com.molang.talk.R
import com.molang.talk.common.extension.toInflate
import com.molang.talk.ui.common.base.BaseRecyclerViewAdapter
import com.molang.talk.ui.common.base.BaseViewHolder
import com.molang.talk.ui.point.adapter.holder.PointHistoryVH
import com.molang.talk.ui.point.model.PointHistoryModel

class PointHistoryRecyclerViewAdapter : BaseRecyclerViewAdapter<PointHistoryModel>() {
    override fun bindVH(holder: BaseViewHolder<*, *>, position: Int) {
        when(holder) {
            is PointHistoryVH -> holder.bind(itemList[position])
        }
    }

    override fun createVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        return PointHistoryVH(parent.toInflate(R.layout.holder_point_history))
    }
}