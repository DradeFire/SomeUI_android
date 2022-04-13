package com.example.someui_app.fragments.base_botton.menu.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.someui_app.databinding.ItemHeaderBinding
import com.example.someui_app.fragments.base_botton.menu.model.HeaderRcModel

class HeaderAdapter(headers: ArrayList<HeaderRcModel>, private val context: Context)
    : RecyclerView.Adapter<HeaderAdapter.ItemViewHolder>() {

    private var headersList = headers

    class ItemViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HeaderRcModel, context: Context) = with(binding) {
            Glide.with(context)
                .load(item.imageUrl.toInt())
                .into(imHeader)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemHeaderBinding
                .inflate(LayoutInflater
                    .from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = headersList[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return headersList.size
    }

}