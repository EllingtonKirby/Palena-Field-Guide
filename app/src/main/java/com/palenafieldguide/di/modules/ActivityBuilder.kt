package com.palenafieldguide.di.modules

import com.palenafieldguide.di.scopes.PerActivity
import com.palenafieldguide.ui.bottomnav.BottomNavActivity
import com.palenafieldguide.ui.bottomnav.BottomNavActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = [BottomNavActivityModule::class])
    abstract fun bindsDrawerActivity(): BottomNavActivity
}