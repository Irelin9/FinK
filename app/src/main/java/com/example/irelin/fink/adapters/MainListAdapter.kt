package com.example.irelin.fink.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.irelin.fink.R
import android.view.ViewAnimationUtils
import android.animation.Animator
import com.example.irelin.fink.data.models.Transaction


class MainListAdapter(private val list: List<Transaction>, private val listener: (String, View) -> Unit):
        RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.main_list_item, parent, false)
        return MainListAdapter.ViewHolder(view)
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var title: TextView
        var image: ImageView

        constructor(itemView: View) : super(itemView) {
            title = itemView.findViewById(R.id.title)
            image = itemView.findViewById(R.id.transactionImage)
        }

        fun bind(item: Transaction, listener: (String, View) -> Unit) {
            with(itemView) {
                title.text = item.text
                image.setOnClickListener({ listener(item.text, image) })
                setOnClickListener { animateLayout() }
            }
        }

        private fun animateLayout() {
            // previously invisible view
            /*val view = findViewById(R.id.my_view)

// get the center for the clipping circle
            val centerX = (view.getLeft() + view.getRight()) / 2
            val centerY = (view.getTop() + view.getBottom()) / 2

            val startRadius = 0
// get the final radius for the clipping circle
            val endRadius = Math.max(view.getWidth(), view.getHeight())

// create the animator for this view (the start radius is zero)
            val anim = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius.toFloat(), endRadius.toFloat())

// make the view visible and start the animation
            view.setVisibility(View.VISIBLE)
            anim.start()*/
        }
    }
}