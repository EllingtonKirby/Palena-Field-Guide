package com.palenafieldguide.ui.bottomnav

import com.palenafieldguide.ui.squares.SquaresFragment
import dagger.Module

@Module(includes = [BottomNavActivityModule.SquaresFragmentModule::class])
class BottomNavActivityModule {
    @Module
    class SquaresFragmentModule {

    }
}