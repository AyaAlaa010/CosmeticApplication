package com.aya.cosmeticapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.aya.cosmeticapplication.R
import com.aya.cosmeticapplication.databinding.ActivityMainBinding
import com.aya.cosmeticapplication.ui.home.AllProductsFragment
import com.aya.cosmeticapplication.ui.favourites.FavouritesFragment
import com.aya.cosmeticapplication.ui.settings.SettingsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.AllProductsFragment -> loadFragment(AllProductsFragment())
                R.id.FavouritesFragment -> loadFragment(FavouritesFragment())
                R.id.SettingsFragment -> loadFragment(SettingsFragment())
                }
            true
        }}

    private fun loadFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView_main, fragment)
            commit()
        }
    }

