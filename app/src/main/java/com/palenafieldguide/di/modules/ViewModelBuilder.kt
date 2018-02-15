package com.palenafieldguide.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.palenafieldguide.di.utils.ViewModelKey
import com.palenafieldguide.ui.mvp.viewmodel.ViewModelFactory
import com.palenafieldguide.ui.squares.SquaresFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(SquaresFragmentViewModel::class)
    abstract fun bindSquaresViewModel(viewModel: SquaresFragmentViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}