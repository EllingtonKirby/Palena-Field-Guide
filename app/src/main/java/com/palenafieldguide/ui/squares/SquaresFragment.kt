package com.palenafieldguide.ui.squares

import android.os.Bundle
import android.view.View
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}