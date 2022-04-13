package com.example.someui_app.fragments.base_botton.menu.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.someui_app.databinding.ItemEatBinding
import com.example.someui_app.fragments.base_botton.menu.model.BaseRcModel

class BaseAdapter(base: ArrayList<BaseRcModel>, private val context: Context)
    : RecyclerView.Adapter<BaseAdapter.ItemViewHolder>() {

    private var baseList = base

    class ItemViewHolder(private val binding: ItemEatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: BaseRcModel, context: Context) = with(binding) {
            txName.text = item.name
            txDescr.text = item.descr

            btBuy.text = "от ${item.cost} р"

            Glide.with(context)
                .load(item.imageUrl.toInt())
                .centerCrop()
                .into(imFood)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemEatBinding
            .inflate(LayoutInflater
                .from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = baseList[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return baseList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(headersModel: ArrayList<BaseRcModel>) {
        baseList = headersModel
        notifyDataSetChanged()
    }
}