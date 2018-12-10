package com.example.thomasperrin.pokerhh.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseActivity
import com.example.thomasperrin.pokerhh.ui.account.AccountFragment
import com.example.thomasperrin.pokerhh.ui.allhands.AllHandsFragment
import com.example.thomasperrin.pokerhh.ui.myhands.MyHandsFragment
import com.example.thomasperrin.pokerhh.ui.newhand.NewHandActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceFragment(0)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_dashboard -> {
                replaceFragment(1)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                replaceFragment(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        addHistory.setOnClickListener {
            intent = Intent(this,NewHandActivity::class.java)
            startActivity(intent)
        }
    }

    private fun replaceFragment(position: Int){
        when(position){
            0 -> setFragment(AllHandsFragment.newInstance())
            1 -> setFragment(AccountFragment.newInstance())
            2 -> setFragment(MyHandsFragment.newInstance())
        }
    }

    private fun setFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment,fragment.tag).commit()
    }

}
