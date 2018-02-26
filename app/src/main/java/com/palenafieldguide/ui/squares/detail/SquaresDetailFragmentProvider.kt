package com.palenafieldguide.ui.squares.detail

import com.palenafieldguide.ui.bottomnav.BottomNavActivityModule.SquaresFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class SquaresDetailFragmentProvider {

    @ContributesAndroidInjector(modules = [SquaresFragmentModule::class])
    internal abstract fun provideSquaresFragmentFactory(): SquaresDetailFragment
}