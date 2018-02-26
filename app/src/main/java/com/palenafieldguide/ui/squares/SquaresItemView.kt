package com.palenafieldguide.ui.squares

import android.content.Context
import android.support.v7.widget.CardView
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.FrameLayout
import com.palenafieldguide.R
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.ui.mvp.base.BaseView


class SquaresItemView(val mContext: Context?) : FrameLayout(mContext!!), BaseView {

    init {
        inflate(mContext, R.layout.item_squares_view, this)
        layoutParams = MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun bind(model : SquaresModel) {
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}