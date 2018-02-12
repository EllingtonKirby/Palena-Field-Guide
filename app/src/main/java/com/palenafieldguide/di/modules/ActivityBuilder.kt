package com.palenafieldguide.di.modules

import com.palenafieldguide.di.utils.PerActivity
import com.palenafieldguide.ui.bottomnav.BottomNavActivity
import com.palenafieldguide.ui.bottomnav.BottomNavActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindsBottomNavActivity(): BottomNavActivity
}