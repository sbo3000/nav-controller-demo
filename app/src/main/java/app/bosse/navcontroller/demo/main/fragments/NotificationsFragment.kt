package app.bosse.navcontroller.demo.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import app.bosse.navcontroller.demo.R

class NotificationsFragment : Fragment() {

    private val safeArgs by lazy { NotificationsFragmentArgs.fromBundle(arguments) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_notifications, container, false)


    override fun onResume() {
        super.onResume()

        context?.let {
            Toast.makeText(it, "deeplink: ${safeArgs.text}", Toast.LENGTH_LONG).show()
        }
    }
}