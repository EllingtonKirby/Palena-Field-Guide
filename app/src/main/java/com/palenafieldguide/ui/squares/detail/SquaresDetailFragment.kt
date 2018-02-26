package com.palenafieldguide.ui.squares.detail

import com.palenafieldguide.R
import com.palenafieldguide.databinding.FragmentSquaresDetailBinding
import com.palenafieldguide.ui.mvp.viewmodel.ViewModelFragment


class SquaresDetailFragment : ViewModelFragment<FragmentSquaresDetailBinding, SquaresDetailFragmentViewModel>() {

    companion object {
        fun newInstance(): SquaresDetailFragment {
            return SquaresDetailFragment()
        }

    }

    override fun observeLiveData() {

    }

    override val layoutResourceId: Int
        get() = R.layout.fragment_squares_detail
}