package com.palenafieldguide.ui.bottomnav

import dagger.Module

@Module(includes = [BottomNavActivityModule.SquaresFragmentModule::class])
class BottomNavActivityModule {
    @Module
    class SquaresFragmentModule {

    }
}