package smyo.app.ui.addoutfit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddOutfitViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Outfit Fragment"
    }
    val text: LiveData<String> = _text
}