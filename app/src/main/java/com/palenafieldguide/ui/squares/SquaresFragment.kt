package com.palenafieldguide.ui.squares

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.palenafieldguide.R
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.databinding.FragmentSquaresBinding
import com.palenafieldguide.ui.mvp.viewmodel.ViewModelFragment
import kotlinx.android.synthetic.main.fragment_squares.*
import javax.inject.Inject


class SquaresFragment : ViewModelFragment<FragmentSquaresBinding, SquaresFragmentViewModel>(), SquaresFragmentView {

    override val layoutResourceId: Int
        get() = R.layout.fragment_squares

    @Inject
    lateinit var adapter: SquaresGridAdapter

    companion object {
        fun newInstance(): SquaresFragment {
            return SquaresFragment()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SquaresFragmentViewModel::class.java)
        swipe_refresh_layout.setOnRefreshListener({ viewModel.generateRandomList() })
        setupGridAdapter(4)
        observeLiveData()
        viewModel.generateRandomList()
    }

    override fun observeLiveData() {
        viewModel.squaresData.observe(this, Observer<List<SquaresModel>> {
            if (it != null) {
                swipe_refresh_layout.isRefreshing = false
                adapter.setItems(it)
                squares_grid.startLayoutAnimation()
            }
        })
    }

    override fun setupGridAdapter(spanCount: Int) {
        squares_grid.layoutManager = GridLayoutManager(activity, spanCount)
        squares_grid.adapter = adapter
    }

    override fun showProgress() {

    }


}
