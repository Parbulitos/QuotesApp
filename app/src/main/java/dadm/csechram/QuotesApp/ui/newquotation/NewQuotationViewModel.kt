package dadm.csechram.QuotesApp.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dadm.csechram.QuotesApp.domain.model.Quotation

class NewQuotationViewModel : ViewModel() {
    //Private properties
    private val userName : MutableLiveData<String> = MutableLiveData(getUserName())
    private val quotation : MutableLiveData<Quotation> = MutableLiveData()
    private val isRefreshing : MutableLiveData<Boolean> = MutableLiveData(false)

    //Inmutable properties
    val userNameGetter: LiveData<String> get() {
        return this.userName
    }
    val quotationGetter: LiveData<Quotation> get() {
        return this.quotation
    }
    val isRefreshingGetter: LiveData<Boolean> get() {
        return this.isRefreshing
    }
    val isGreetingsVisible = Transformations.map(quotation){it == null}
    //Getters
    private fun getUserName() : String{
        return setOf("Alice","Bob","Charlie","David","Emma").random()
    }
    fun getNewQuotation(){
        isRefreshing.value = true
        val num = (0..99).random().toString()
        quotation.value = Quotation(num,"Quotation text #$num", "Author #$num")
        isRefreshing.value = false
    }
}