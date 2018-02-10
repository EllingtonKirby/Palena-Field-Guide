package com.palenafieldguide.app.databinding

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.RecyclerView

@BindingAdapter("android:onNavigationListener")
fun setNavigationListener(view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener) {
    view.setOnNavigationItemSelectedListener(listener)
}

@BindingAdapter("android:nestedScrollingEnabled")
fun setNestedSrollingEnabled(view: RecyclerView, set: Boolean) {
    view.isNestedScrollingEnabled = set
}