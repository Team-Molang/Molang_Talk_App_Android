package com.molang.talk.ui.common.base

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<BINDING: ViewDataBinding, MODEL: BaseModel>(
    protected var binding: BINDING
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(model: MODEL)
}