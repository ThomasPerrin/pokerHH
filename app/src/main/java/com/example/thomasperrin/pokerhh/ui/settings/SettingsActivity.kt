package com.example.thomasperrin.pokerhh.ui.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.settings.filter.FilterFragment

class SettingsActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        replace(FilterFragment())
    }

    fun replace(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }

}