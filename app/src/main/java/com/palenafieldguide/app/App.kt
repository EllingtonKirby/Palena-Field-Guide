package com.palenafieldguide.app

import android.app.Activity
import android.app.Application
import com.palenafieldguide.di.components.DaggerAppComponent
import com.palenafieldguide.di.modules.BaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

open class App : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().build().inject(this)
    }
}