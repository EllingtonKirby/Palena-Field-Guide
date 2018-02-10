package com.palenafieldguide.ui.squares

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.ui.mvp.recycler.BaseViewHolder
import com.palenafieldguide.ui.squares.SquaresGridAdapter.SquaresGridViewHolder

class SquaresGridAdapter : RecyclerView.Adapter<SquaresGridViewHolder>() {
    override fun onBindViewHolder(holder: SquaresGridViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SquaresGridViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class SquaresGridViewHolder(val itemView : View) : BaseViewHolder<SquaresModel>(itemView) {
        override fun bind(data : SquaresModel) {

        }

    }
}
