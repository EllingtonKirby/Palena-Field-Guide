package com.palenafieldguide.ui.squares

import com.palenafieldguide.ui.bottomnav.BottomNavActivityModule.SquaresFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class SquaresFragmentProvider {

    @ContributesAndroidInjector(modules = [SquaresFragmentModule::class])
    internal abstract fun provideSquaresFragmentFactory(): SquaresFragment
}
