package com.palenafieldguide.ui.squares

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.palenafieldguide.api.models.SquaresModel
import com.squareup.picasso.Picasso
import javax.inject.Inject


class SquaresFragmentViewModel @Inject constructor(var picasso: Picasso) : ViewModel() {

    var squaresData: MutableLiveData<List<SquaresModel>>? = MutableLiveData()
}