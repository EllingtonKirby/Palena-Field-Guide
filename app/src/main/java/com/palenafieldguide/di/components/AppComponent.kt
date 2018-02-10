package com.palenafieldguide.di.components

import com.palenafieldguide.app.App
import com.palenafieldguide.di.modules.ActivityBuilder
import com.palenafieldguide.di.modules.BaseModule
import com.palenafieldguide.di.modules.NetworkingModule
import com.palenafieldguide.di.modules.ViewModelModule
import com.palenafieldguide.di.utils.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            BaseModule::class,
            NetworkingModule::class,
            ActivityBuilder::class,
            ViewModelModule::class
        ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}