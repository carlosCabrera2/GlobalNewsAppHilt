package com.example.globalnewsapphilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.globalnewsapphilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val hostFragment = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment

      binding.bottomNav.setupWithNavController(hostFragment.navController)

      setupActionBarWithNavController(hostFragment.navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.frag_container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }



}