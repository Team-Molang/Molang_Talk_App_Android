package com.molang.talk.ui.common.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : BaseModel> : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    protected val itemList: MutableList<T> = mutableListOf()

    abstract fun createVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *>
    abstract fun bindVH(holder: BaseViewHolder<*, *>, position: Int)

    fun setItemList(list: MutableList<T>) {
        val callback = BaseDiffCallback(itemList, list)
        val diffResult = DiffUtil.calculateDiff(callback)
        itemList.clear()
        itemList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        return createVH(parent, viewType)
    }

    override fun getItemCount(): Int = itemList.count()

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        bindVH(holder, position)
    }
}