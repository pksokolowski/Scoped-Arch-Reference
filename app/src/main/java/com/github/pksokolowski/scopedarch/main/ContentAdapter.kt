package com.github.pksokolowski.scopedarch.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.pksokolowski.scopedarch.R
import com.github.pksokolowski.scopedarch.databinding.ViewContentListItemBinding
import com.github.pksokolowski.scopedarch.model.Content
import java.util.*

internal class ContentAdapter(private val onClick: ItemClickedListener? = null) :
    RecyclerView.Adapter<ContentAdapter.ContentViewHolder?>() {
    private val data: MutableList<Content> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_content_list_item, parent, false)
        return ContentViewHolder(itemView, onClick)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(contents: Collection<Content>?) {
        if (contents != null) {
            val diffResult: DiffUtil.DiffResult =
                DiffUtil.calculateDiff(RepoDiffCallback(data, contents.toList()))
            data.clear()
            data.addAll(contents)
            diffResult.dispatchUpdatesTo(this)
        } else {
            data.clear()
            notifyDataSetChanged()
        }
    }

    internal class ContentViewHolder(
        view: View,
        onClick: ItemClickedListener? = null
    ) : RecyclerView.ViewHolder(view) {
        val binding = ViewContentListItemBinding.bind(view)
        var content: Content? = null

        init {
            itemView.setOnClickListener { v: View? ->
                content?.let {
                    onClick?.onItemClicked(it)
                }
            }
        }

        fun bind(content: Content) {
            this.content = content
        }
    }

    interface ItemClickedListener {
        fun onItemClicked(content: Content)
    }
}