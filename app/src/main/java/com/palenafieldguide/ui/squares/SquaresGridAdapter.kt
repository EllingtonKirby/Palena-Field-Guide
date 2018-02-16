package com.palenafieldguide.ui.squares

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.view.animation.AnimationSet
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.ui.mvp.recycler.BaseViewHolder
import com.palenafieldguide.ui.squares.SquaresGridAdapter.SquaresGridViewHolder
import javax.inject.Inject

class SquaresGridAdapter @Inject constructor() : RecyclerView.Adapter<SquaresGridViewHolder>() {

    private val DURATION = 200
    var items: ArrayList<SquaresModel> = ArrayList()

    override fun onBindViewHolder(holder: SquaresGridViewHolder?, position: Int) {
        val squaresView: SquaresItemView = holder?.itemView as SquaresItemView
        squaresView.bind(items[position])
//        squaresView.x = 100f
//        squaresView.y = 100f
//        squaresView.animate()
//                .translationX(0f)
//                .translationY(0f)
        
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SquaresGridViewHolder {
        return SquaresGridViewHolder(SquaresItemView(parent?.context))
    }

    fun setItems(newItems: List<SquaresModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class SquaresGridViewHolder(val squaresView: SquaresItemView) : BaseViewHolder<SquaresModel>(squaresView)
}
