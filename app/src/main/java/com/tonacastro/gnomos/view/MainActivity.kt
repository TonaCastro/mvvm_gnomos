package com.tonacastro.gnomos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tonacastro.gnomos.R
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.view.detail.DetailFragment
import com.tonacastro.gnomos.view.main.MainFragment

class MainActivity : AppCompatActivity(), MainFragment.GnomoSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            val fragment = MainFragment.newInstance()
            fragment.setGnomoSelectedListener(this)
            changeFragment(fragment,MainFragment::javaClass.name)
        }
    }

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment,tag)
            .commit()
    }

    override fun gnomoSelected(service: GnomoModel) {
        val fragment = DetailFragment.newInstance()
        changeFragment(fragment,DetailFragment::javaClass.name)
    }

}
