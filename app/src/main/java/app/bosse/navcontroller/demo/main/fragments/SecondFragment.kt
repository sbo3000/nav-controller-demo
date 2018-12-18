package app.bosse.navcontroller.demo.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import app.bosse.navcontroller.demo.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    private val safeArgs by lazy { SecondFragmentArgs.fromBundle(arguments) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = ChangeBounds()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("###", "safeArg = [${safeArgs.data.first()}]")

        context?.let { context ->
            imageView.setImageDrawable(ContextCompat.getDrawable(context, safeArgs.drawableId))
        }
    }
}