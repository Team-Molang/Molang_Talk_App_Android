package com.molang.talk.ui.common.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T : Any> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val itemList: MutableList<T> = mutableListOf()

    abstract fun createVH(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    abstract fun bindVH(holder: RecyclerView.ViewHolder, position: Int)

    fun setItemList(list: MutableList<T>) {
        val callback = BaseDiffCallback(itemList, list)
        val diffResult = DiffUtil.calculateDiff(callback)
        itemList.clear()
        itemList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return createVH(parent, viewType)
    }

    override fun getItemCount(): Int = itemList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindVH(holder, position)
    }
}