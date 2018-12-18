package app.bosse.navcontroller.demo.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.bosse.navcontroller.demo.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private val safeArgs by lazy { FirstFragmentArgs.fromBundle(arguments) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diveIntoButton.setOnClickListener {
            findNavController().navigate(
                FirstFragmentDirections
                    .goToSecond(safeArgs.drawableId)
            )
        }
    }

    override fun onResume() {
        super.onResume()

        context?.let { context ->
            imageView.setImageDrawable(ContextCompat.getDrawable(context, safeArgs.drawableId))
        }
    }
}