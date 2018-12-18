package app.bosse.navcontroller.demo.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import app.bosse.navcontroller.demo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController by lazy { Navigation.findNavController(this@MainActivity, R.id.navHost) }

    private val topLevelDestinations by lazy {
        setOf(R.id.dest_home,
              R.id.dest_dashboard,
              R.id.dest_notifications)
    }

    private val appBarConfig by lazy {
        AppBarConfiguration(topLevelDestinations)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        toolbar.setupWithNavController(navController, appBarConfig)

        bottomNavigation.setupWithNavController(navController)

        // feature toggle
        bottomNavigation.menu.findItem(R.id.dest_notifications)?.isVisible = true

        navController.addOnDestinationChangedListener() { _, destination, _ ->
            Log.e("###", "destination.label=${destination.label.toString()}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle proper up navigation with navController
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}
