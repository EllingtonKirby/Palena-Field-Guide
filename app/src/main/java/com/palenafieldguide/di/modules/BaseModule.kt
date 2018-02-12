package com.palenafieldguide.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule {
    @Provides @Singleton fun providesApplication(application: Application) : Context = application
}