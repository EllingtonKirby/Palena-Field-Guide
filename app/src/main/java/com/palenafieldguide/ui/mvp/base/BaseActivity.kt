package com.palenafieldguide.ui.mvp.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import dagger.android.AndroidInjector



abstract class BaseActivity<T : ViewDataBinding> : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    lateinit var binding: T
    @get:LayoutRes protected abstract val layoutResourceId: Int

    @Inject lateinit var mAndroidInjector: DispatchingAndroidInjector<Fragment>

    /**
     * Provides the {@link AndroidInjector} needed to construct the sub-component and inject
     * required dependencies for child fragments of this activity. The Injector is provided via the
     * map constructed in the {@link DispatchingAndroidInjector}
     */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mAndroidInjector
    }

    /**
     * When the activity is created, the application context is queried via the {@DispatchingAndroidInjector}
     * to find the relevant {@link AndroidInjector} for this activity
     *
     * The @ContributesAndroidInjector listing in the {@link ActivityBuilder} informs the compiler
     * that a sub-component for the class with the return type of the relevant method
     * should be constructed, and the dependencies listed in the passed module should be provided
     *
     * The DispatchingAndroidInjector then contains the mapping of the relevant AndroidInjector's to
     * the targeted class
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
    }


    fun View.showSnackbar(s: String, len: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
        val snack = Snackbar.make(this, s, len)
        snack.f()
        snack.show()
    }
}