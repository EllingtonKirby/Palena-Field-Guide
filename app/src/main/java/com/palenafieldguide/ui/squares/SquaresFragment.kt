package com.palenafieldguide.ui.squares

import com.palenafieldguide.R
import com.palenafieldguide.databinding.FragmentSquaresBinding
import com.palenafieldguide.ui.mvp.base.BaseFragment

class SquaresFragment : BaseFragment<FragmentSquaresBinding>() {

    companion object {
        fun newInstance(): SquaresFragment {
            return SquaresFragment()
        }

    }

    override val layoutResourceId: Int
        get() = R.layout.fragment_squares


}