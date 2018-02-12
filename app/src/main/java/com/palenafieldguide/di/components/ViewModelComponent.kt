package com.palenafieldguide.di.components

import com.palenafieldguide.di.modules.ViewModelModule
import com.palenafieldguide.ui.squares.SquaresFragmentViewModel
import dagger.Component


@Component(modules = [ViewModelModule::class])
interface ViewModelComponent {
    fun inject(viewModel : SquaresFragmentViewModel)
}