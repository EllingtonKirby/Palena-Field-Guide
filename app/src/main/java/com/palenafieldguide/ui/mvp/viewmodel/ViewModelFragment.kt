package com.palenafieldguide.ui.mvp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ViewDataBinding
import com.palenafieldguide.ui.mvp.base.BaseFragment
import javax.inject.Inject

abstract class ViewModelFragment<T : ViewDataBinding, V : ViewModel> : BaseFragment<T>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: V

    override fun onStart() {
        super.onStart()
        observeLiveData()
    }

    abstract fun observeLiveData()
}