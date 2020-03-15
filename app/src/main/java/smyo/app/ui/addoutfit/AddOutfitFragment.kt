package smyo.app.ui.addoutfit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import smyo.app.R

class AddOutfitFragment : Fragment() {

    private lateinit var addOutfitViewModel: AddOutfitViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addOutfitViewModel =
                ViewModelProviders.of(this).get(AddOutfitViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_addoutfit, container, false)
        val textView: TextView = root.findViewById(R.id.text_addoutfit)
        addOutfitViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
