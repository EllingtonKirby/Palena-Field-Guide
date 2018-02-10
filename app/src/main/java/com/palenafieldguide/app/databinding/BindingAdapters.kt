package com.palenafieldguide.app.databinding

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView

@BindingAdapter("bind:onNavigationListener")
fun setNavigationListener(view: BottomNavigationView, listener: BottomNavigationView.OnNavigationItemSelectedListener) {
    view.setOnNavigationItemSelectedListener(listener)
}