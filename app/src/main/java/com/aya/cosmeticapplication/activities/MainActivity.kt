package com.aya.cosmeticapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aya.cosmeticapplication.R
import com.aya.cosmeticapplication.ui.AllProductsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, AllProductsFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}