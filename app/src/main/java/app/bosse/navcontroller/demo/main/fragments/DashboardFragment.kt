package app.bosse.navcontroller.demo.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import app.bosse.navcontroller.demo.R
import app.bosse.navcontroller.demo.login.AuthViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var model: AuthViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = activity?.run {
            ViewModelProviders
                .of(this)
                .get(AuthViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        loginButton.setOnClickListener {
            findNavController().navigate(
                DashboardFragmentDirections
                    .goToLogin()
            )
        }
    }

    override fun onResume() {
        super.onResume()
        context?.run {
            Toast
                .makeText(this, "auth status = ${model.authStatus.value}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}