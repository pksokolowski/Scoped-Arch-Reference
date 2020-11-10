package com.github.pksokolowski.scopedarch.main

import androidx.recyclerview.widget.DiffUtil
import com.github.pksokolowski.scopedarch.model.Content

class RepoDiffCallback(
    private val oldList: List<Content>,
    private val newList: List<Content>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].equals(newList[newItemPosition])
    }

}