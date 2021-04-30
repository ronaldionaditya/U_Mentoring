package com.mobile.umentoring.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mobile.umentoring.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

//    private val homeFragment = HomeFragment()
//    private val infoFragment = InfoFragment()
//    private val vacancyListFragment = VacancyListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val navController = Navigation.findNavController(this,R.id.home_nav_host_fragment)
        NavigationUI.setupWithNavController(btmNavigation, navController)

//        replaceFragment(homeFragment)
//
//        btmNavigation.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.ic_home -> replaceFragment(homeFragment)           }
//        }

    }

//    private fun replaceFragment(fragment: Fragment){
//        if(fragment != null){
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.nav_host_fragment_container,fragment)
//            transaction.commit()
//        }
//    }
}