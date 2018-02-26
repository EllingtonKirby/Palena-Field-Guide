package com.palenafieldguide.ui.bottomnav

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.palenafieldguide.R
import com.palenafieldguide.databinding.ActivityBottomNavBinding
import com.palenafieldguide.ui.mvp.base.BaseActivity
import com.palenafieldguide.ui.squares.SquaresFragment

class BottomNavActivity(override val layoutResourceId: Int = R.layout.activity_bottom_nav) : BaseActivity<ActivityBottomNavBinding>(), BottomNavigationView.OnNavigationItemSelectedListener {

    companion object {
        public var currentPosition : Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navListener = this

        supportFragmentManager.beginTransaction().replace(R.id.container, SquaresFragment.newInstance()).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }


}