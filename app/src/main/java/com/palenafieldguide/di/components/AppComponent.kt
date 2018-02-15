package com.palenafieldguide.di.components

import android.app.Application
import com.palenafieldguide.app.App
import com.palenafieldguide.di.modules.ActivityBuilder
import com.palenafieldguide.di.modules.BaseModule
import com.palenafieldguide.di.modules.NetworkingModule
import com.palenafieldguide.di.modules.ViewModelModule
import com.palenafieldguide.di.utils.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.BindsInstance




@PerApplication
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            BaseModule::class,
            NetworkingModule::class,
            ViewModelModule::class,
            ActivityBuilder::class
        ]
)

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: Application)
}