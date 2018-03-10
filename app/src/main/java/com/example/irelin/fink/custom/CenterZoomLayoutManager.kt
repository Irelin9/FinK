package com.example.irelin.fink.custom

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class CenterZoomLayoutManager : LinearLayoutManager {

    private val mShrinkAmount : Float = 0.15f
    private val mShrinkDistance : Float = 0.9f

    constructor(context : Context) : super(context) {
    }

    constructor(context : Context, orientation : Int, reverseLayout : Boolean)
            : super(context, orientation, reverseLayout) {
    }


    override fun scrollVerticallyBy(dy : Int, recycler : RecyclerView.Recycler, state : RecyclerView.State) : Int {
        if (orientation == VERTICAL) {
            val scrolled : Int = super.scrollVerticallyBy(dy, recycler, state);
            val midpoint : Float = height / 2f
            val d0 = 0f
            val d1 : Float = mShrinkDistance * midpoint
            val s0 = 1f
            val s1 : Float = 1f - mShrinkAmount
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                val childMidpoint = (getDecoratedBottom(child) + getDecoratedTop(child)) / 2f
                val d = Math.min(d1, Math.abs(midpoint - childMidpoint))
                val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
                child.scaleX = scale
                child.scaleY = scale
            }
            return scrolled
        } else {
            return 0
        }
    }

    override fun scrollHorizontallyBy(dx : Int, recycler : RecyclerView.Recycler, state : RecyclerView.State) : Int {
        if (orientation == HORIZONTAL) {
            val scrolled : Int = super.scrollHorizontallyBy(dx, recycler, state);

            val midpoint : Float = width / 2f
            val d0 = 0f
            val d1 : Float = mShrinkDistance * midpoint
            val s0 = 1f
            val s1 : Float = 1f - mShrinkAmount
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                val childMidpoint = (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f
                val d = Math.min(d1, Math.abs(midpoint - childMidpoint))
                val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
                child.scaleX = scale
                child.scaleY = scale
            }
            return scrolled
        } else {
            return 0
        }

    }
}