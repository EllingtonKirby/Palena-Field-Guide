package com.palenafieldguide.di.components

import com.palenafieldguide.di.modules.ViewModelBuilder
import com.palenafieldguide.ui.squares.SquaresFragmentViewModel
import dagger.Component


@Component(modules = [ViewModelBuilder::class])
interface ViewModelComponent {
    fun inject(viewModel : SquaresFragmentViewModel)
}