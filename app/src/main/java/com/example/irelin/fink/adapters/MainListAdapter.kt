package com.example.irelin.fink.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.irelin.fink.R
import com.example.irelin.fink.data.models.Transaction


class MainListAdapter(private val list: List<Transaction>, private val listener: (String, View) -> Unit):
        RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(list[position], listener)
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.main_list_item, parent, false)
        return MainListAdapter.ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ImageView

        fun bind(item: Transaction, listener: (String, View) -> Unit) {
            with(itemView) {
                title.text = item.text
                setOnClickListener({ listener(item.text, image) })
            }
        }

        init {
            title = itemView.findViewById(R.id.title)
            image = itemView.findViewById(R.id.transactionImage)
        }
    }
}