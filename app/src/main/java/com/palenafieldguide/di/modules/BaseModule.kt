package com.palenafieldguide.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class BaseModule {
    @Provides fun providesApplication(application: Application) : Context = application
}