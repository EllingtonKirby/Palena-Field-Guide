package com.palenafieldguide.ui.mvp.viewmodel

import android.arch.lifecycle.ViewModelProvider
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment

class ViewModelFragment<T : ViewDataBinding, V : ViewModelProvider.Factory> : Fragment()