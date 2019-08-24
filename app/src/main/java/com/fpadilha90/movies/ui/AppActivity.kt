package com.fpadilha90.movies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.fpadilha90.movies.R
import kotlinx.android.synthetic.main.activity_app.*

class AppActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
//        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration(getNavHostFragment().navController.graph)

        setupActionBarWithNavController(getNavHostFragment().navController, appBarConfiguration)

//        bottom_nav_view.setupWithNavController(getNavHostFragment().navController)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)

    private fun getNavHostFragment() = (my_nav_host_fragment as NavHostFragment)

}