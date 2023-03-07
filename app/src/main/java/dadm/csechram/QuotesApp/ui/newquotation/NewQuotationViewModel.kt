package dadm.csechram.QuotesApp.ui.newquotation

import androidx.lifecycle.*
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepository
import dadm.csechram.QuotesApp.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel(@Inject private val repository: NewQuotationRepository) : ViewModel() {
    //Private properties
    private val userName : MutableLiveData<String> = MutableLiveData(getUserName())
    private val quotation : MutableLiveData<Quotation> = MutableLiveData()
    private val isRefreshing : MutableLiveData<Boolean> = MutableLiveData(false)
    private val favButtonVisible : MutableLiveData<Boolean> = MutableLiveData(false)
    private val exception : MutableLiveData<Throwable?> = MutableLiveData(Throwable())
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
    val favButtonVisibleGetter: LiveData<Boolean> get() {
        return this.favButtonVisible
    }
    val exceptionGetter: LiveData<Throwable?> get(){
        return this.exception
    }
    val isGreetingsVisible = Transformations.map(quotation){it == null}

    //Getters
    private fun getUserName() : String{
        return setOf("Alice","Bob","Charlie","David","Emma").random()
    }
    fun getNewQuotation(){
        isRefreshing.value = true
        /*val num = (0..99).random().toString()
        quotation.value = Quotation(num,"Quotation text #$num", "Author #$num")*/
        viewModelScope.launch {
            repository.getNewQuotation().fold(
                onSuccess = {
                    quotation.value = it},
                onFailure = {
                    exception.value = it
            })
        }
        isRefreshing.value = false
        favButtonVisible.value = true
    }

    fun addToFavourites(){
        favButtonVisible.value = !favButtonVisible.value!!
    }

    fun resetError(){
        exception.value = null
    }
}