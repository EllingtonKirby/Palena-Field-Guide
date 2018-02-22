package com.palenafieldguide.ui.squares

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.palenafieldguide.api.models.SquaresModel
import com.squareup.picasso.Picasso
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Inject


class SquaresFragmentViewModel @Inject constructor(var picasso: Picasso) : ViewModel() {

    var squaresData: MutableLiveData<List<SquaresModel>> = MutableLiveData()

    fun onStart() {
        generateRandomList()
    }

    fun generateRandomList() {
        var list: ArrayList<SquaresModel> = ArrayList()
        list.apply {
            (10..20).randomInRange().mapTo(list) { SquaresModel(it.toString()) }

        }
        squaresData.postValue(list)
    }

    private fun IntRange.randomInRange(): IntRange {
        val min = start
        val max = ThreadLocalRandom.current().nextInt(endInclusive) + start
        return min..max
    }
}