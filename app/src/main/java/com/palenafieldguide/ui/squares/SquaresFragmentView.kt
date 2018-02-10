package com.palenafieldguide.ui.squares

import com.palenafieldguide.ui.mvp.base.BaseView


interface SquaresFragmentView : BaseView {
    fun setupGridAdapter(spanCount : Int)
}