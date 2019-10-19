package com.molang.talk.ui.common.point.adapter.holder

import com.molang.talk.databinding.HolderPointHistoryBinding
import com.molang.talk.ui.common.base.BaseViewHolder
import com.molang.talk.ui.common.point.model.PointHistoryModel

class PointHistoryVH(b: HolderPointHistoryBinding) :
    BaseViewHolder<HolderPointHistoryBinding, PointHistoryModel>(b) {
    override fun bind(model: PointHistoryModel) {
        binding.data = model
    }
}