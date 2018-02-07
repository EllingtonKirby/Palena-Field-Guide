package com.palenafieldguide.ui.mvp.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding : T

    @get:LayoutRes
    protected abstract val layoutResourceId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)
    }


    fun View.showSnackbar(s: String, len: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
        val snack = Snackbar.make(this, s, len)
        snack.f()
        snack.show()
    }
}