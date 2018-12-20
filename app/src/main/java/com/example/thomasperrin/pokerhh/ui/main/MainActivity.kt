package com.example.thomasperrin.pokerhh.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.thomasperrin.pokerhh.R
import com.example.thomasperrin.pokerhh.ui.BaseActivity
import com.example.thomasperrin.pokerhh.ui.account.AccountFragment
import com.example.thomasperrin.pokerhh.ui.allhands.AllHandsFragment
import com.example.thomasperrin.pokerhh.ui.myhands.MyHandsFragment
import com.example.thomasperrin.pokerhh.ui.newhand.NewHandActivity
import com.example.thomasperrin.pokerhh.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                chooseFragment(0)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_dashboard -> {
                chooseFragment(1)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                chooseFragment(2)
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
            val intent = Intent(this,NewHandActivity::class.java)
            startActivity(intent)
        }
        navigation.selectedItemId = 0
    }

    private fun chooseFragment(position: Int){
        when(position){
            0 -> addFragment(AllHandsFragment.newInstance())
            1 -> addFragment(AccountFragment.newInstance())
            2 -> addFragment(MyHandsFragment.newInstance())
        }
    }

    private fun addFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment,fragment.tag).commit()
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment,fragment.tag).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.filter -> {
                startActivity(Intent(this,SettingsActivity::class.java))
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_action_bar_main_activity, menu)
        return true
    }

}
