package com.molang.talk.common.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.molang.talk.databinding.HolderChattingListBinding

fun<BINDING: ViewDataBinding> ViewGroup.toInflate(@LayoutRes layoutRes: Int): BINDING {
    return DataBindingUtil.inflate(
        LayoutInflater.from(context),
        layoutRes,
        this,
        false
    )
}