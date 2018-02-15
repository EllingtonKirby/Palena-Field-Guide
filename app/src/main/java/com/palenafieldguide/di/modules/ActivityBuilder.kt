package com.palenafieldguide.di.modules

import com.palenafieldguide.di.utils.PerActivity
import com.palenafieldguide.ui.bottomnav.BottomNavActivity
import com.palenafieldguide.ui.bottomnav.BottomNavActivityModule
import com.palenafieldguide.ui.squares.SquaresFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = [BottomNavActivityModule::class, SquaresFragmentProvider::class])
    abstract fun bindsBottomNavActivity(): BottomNavActivity
}