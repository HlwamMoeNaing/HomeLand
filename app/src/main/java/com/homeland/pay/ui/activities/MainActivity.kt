package com.homeland.pay.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.homeland.pay.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        val navController = navHostFragment.navController
        val navGraph = navController.graph

        Log.d("@onBoTst",onBoardingFinished().toString())
        if (onBoardingFinished()){
            navGraph.startDestination = R.id.loginOptionFragment
            navController.graph = navGraph

        }else{
            navGraph.startDestination = R.id.splashFragment
            navController.graph = navGraph

        }

    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = this.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}