package app.bosse.navcontroller.demo.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import app.bosse.navcontroller.demo.R
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment : Fragment() {

    private lateinit var model: AuthViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?) =
        inflater.inflate(R.layout.fragment_auth, container, false)

    override fun onViewCreated(view: View, savedState: Bundle?) {
        super.onViewCreated(view, savedState)

        model = activity?.run {
            ViewModelProviders
                .of(this)
                .get(AuthViewModel::class.java)
        } ?: throw Exception("Invalid Activity")


        loginButton.setOnClickListener {
            if (inputIsValid()) {
                model.update(AuthStatus.CONNECTED)
                // go back to caller
                findNavController().popBackStack()
            }
        }
    }

    /**
     *  Simple validation for input fields.
     */
    private fun inputIsValid(): Boolean {
        val errorView: EditText? =
            when {
                usernameView.text.isNullOrEmpty() -> usernameView
                passwordView.text.isNullOrEmpty() -> passwordView
                else                              -> null
            }

        if (errorView != null) {
            errorView.error = getString(R.string.login_error_prompt)
            return false
        } else {
            return true
        }
    }
}