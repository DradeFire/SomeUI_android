package com.example.someui_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.someui_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = (supportFragmentManager.findFragmentById(R.id.frag_cont)
                as NavHostFragment).navController

        bindButtons(navController)

    }

    private fun bindButtons(navController: NavController) {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.menu_item_food -> {
                    navController.navigate(R.id.menuFragment)
                }
                R.id.menu_item_person -> {
                    navController.navigate(R.id.profileFragment)
                }
                R.id.menu_item_basket -> {
                    navController.navigate(R.id.basketFragment)
                }
            }

            true
        }
    }
}