package com.palenafieldguide.ui.squares

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.palenafieldguide.R
import com.palenafieldguide.api.models.SquaresModel
import com.palenafieldguide.databinding.FragmentSquaresBinding
import com.palenafieldguide.ui.mvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_squares.*
import javax.inject.Inject

class SquaresFragment : BaseFragment<FragmentSquaresBinding>(), SquaresFragmentView {


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var adapter: SquaresGridAdapter
    var viewModel: SquaresFragmentViewModel? = null

    companion object {
        fun newInstance(): SquaresFragment {
            return SquaresFragment()
        }

    }

    override val layoutResourceId: Int
        get() = R.layout.fragment_squares


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SquaresFragmentViewModel::class.java)

        viewModel?.squaresData?.observe(this, Observer<List<SquaresModel>> {
            if (it != null) {
                adapter?.setItems(it)
            }
        })
        setupGridAdapter(4)
        var list: ArrayList<SquaresModel> = ArrayList()
        adapter?.setItems(
                list.apply { (1..10).mapTo(list) { SquaresModel(it.toString()) }
        })

    }

    override fun setupGridAdapter(spanCount: Int) {
        squares_grid.layoutManager = GridLayoutManager(activity, spanCount)
        squares_grid.adapter = adapter
    }

    override fun showProgress() {

    }

}
