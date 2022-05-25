package com.paging3.sample.paging_portion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.paging3.sample.R
import com.paging3.sample.models.Data

class QuotePagingAdapter() :
    PagingDataAdapter<Data, QuotePagingAdapter.MyViewHolder>(COMPARTOR) {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quote = itemView.findViewById<TextView>(R.id.quote)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = getItem(position)
        holder.quote.text = item?.content

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_list, parent, false)
        return MyViewHolder(view)
    }


    companion object {

        private val COMPARTOR=object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return  oldItem._id==newItem._id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem==newItem
            }

        }
    }

}