package dadm.csechram.QuotesApp.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewQuotationViewModel : ViewModel() {
    private val userName : MutableLiveData<String> = MutableLiveData(getUserName())
    val userNameGetter: LiveData<String> get() {
        return this.userName
    }

    private fun getUserName() : String{
        return setOf("Alice","Bob","Charlie","David","Emma").random()
    }
}