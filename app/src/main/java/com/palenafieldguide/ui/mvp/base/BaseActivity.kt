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

    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Fragment>

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mAndroidInjector
    }

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