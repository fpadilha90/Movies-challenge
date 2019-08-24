package com.fpadilha90.movies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.fpadilha90.movies.R

class AppActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)

}