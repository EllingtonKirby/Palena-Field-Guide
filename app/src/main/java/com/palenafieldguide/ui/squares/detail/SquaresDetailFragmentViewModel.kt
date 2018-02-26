package com.palenafieldguide.ui.squares.detail

import android.arch.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject


class SquaresDetailFragmentViewModel @Inject constructor(var picasso: Picasso) : ViewModel()