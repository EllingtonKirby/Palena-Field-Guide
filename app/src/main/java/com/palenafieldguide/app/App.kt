package com.palenafieldguide.app

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.palenafieldguide.di.components.AppComponent
import com.palenafieldguide.di.components.DaggerAppComponent
import com.palenafieldguide.di.modules.BaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class App : Application(), HasActivityInjector, HasSupportFragmentInjector {

    /**
     * Wrappers around mappings of classes descended from android components to relevant injectors
     * Mapping is assembled via @ContributesAndroidInjector annotated methods
     */
    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    /**
     *
     */
    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}