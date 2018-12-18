package app.bosse.navcontroller.demo.camera.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.bosse.navcontroller.demo.R
import kotlinx.android.synthetic.main.fragment_camera.*

class CameraFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_camera, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diveIntoButton.setOnClickListener {
            findNavController().navigate(
                CameraFragmentDirections.goToSettings()
            )
        }
    }
}