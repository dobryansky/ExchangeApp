package com.artem.exchangeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.artem.exchangeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentNavHost)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.ListRatesFragment,
                R.id.FavouriteRatesFragment
            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)

    }
}