package com.molang.talk.ui.common.point.adapter.holder

import com.molang.talk.R
import com.molang.talk.common.extension.getString
import com.molang.talk.common.extension.makeMessage
import com.molang.talk.databinding.HolderPointHistoryBinding
import com.molang.talk.ui.common.base.BaseViewHolder
import com.molang.talk.ui.common.point.model.PointHistoryModel

class PointHistoryVH(b: HolderPointHistoryBinding) :
    BaseViewHolder<HolderPointHistoryBinding, PointHistoryModel>(b) {
    override fun bind(model: PointHistoryModel) {
        binding.run {
            data = model
            tvPoint.text = makeMessage(R.string.home_point_my_point_formatter, model.point).getString(context)
        }
    }
}