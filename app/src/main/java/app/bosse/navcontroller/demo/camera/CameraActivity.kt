package app.bosse.navcontroller.demo.camera

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import app.bosse.navcontroller.demo.R
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {

    private val navController by lazy { navHost.findNavController() }

    private val topLevelDestinations by lazy {
        setOf(R.id.dest_camera,
              R.id.dest_gallery,
              R.id.dest_slideshow)
    }

    private val appBarConfig by lazy { AppBarConfiguration(topLevelDestinations, drawerLayout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        setSupportActionBar(toolbar)

        setupActionBarWithNavController(navController, appBarConfig)

        sideNavView.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig)
    }
}