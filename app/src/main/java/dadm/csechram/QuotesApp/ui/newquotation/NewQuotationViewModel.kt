package dadm.csechram.QuotesApp.ui.newquotation

import androidx.lifecycle.*
import dadm.csechram.QuotesApp.data.favourites.FavouritesRepository
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationManager
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepository
import dadm.csechram.QuotesApp.data.settings.SettingsRepository
import dadm.csechram.QuotesApp.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(private val manager: NewQuotationManager, private val settingsRepository: SettingsRepository, private val favouritesRepository: FavouritesRepository) : ViewModel() {
    //Private properties
    private val quotation : MutableLiveData<Quotation> = MutableLiveData()
    private val isRefreshing : MutableLiveData<Boolean> = MutableLiveData(false)
    private val favButtonVisible : MutableLiveData<Boolean> = MutableLiveData(false)
    private val exception : MutableLiveData<Throwable?> = MutableLiveData(null)

    //Inmutable properties
    val userNameGetter: LiveData<String> get() {
        return settingsRepository.getUsername().asLiveData()
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
    val isGreetingsVisible = quotation.map{it.id.isEmpty()}

    //Getters
    private fun getUserName() : String{
        return setOf("Alice","Bob","Charlie","David","Emma").random()
    }
    fun getNewQuotation(){
        isRefreshing.value = true
        //Coroutine launch
        viewModelScope.launch {
            manager.getNewQuotation().fold(
                onSuccess = {
                    quotation.value = it},
                onFailure = {
                    exception.value = it
            })
        }
        //End of coroutine
        isRefreshing.value = false
        favButtonVisible.value = true
    }

    fun addToFavourites(){
        viewModelScope.launch {
            if(favButtonVisible.value!!){
                favouritesRepository.addQuotation(quotation.value!!)
                favButtonVisible.value = !favButtonVisible.value!!
            }else{
                favouritesRepository.deleteQuotation(quotation.value!!)
                favButtonVisible.value = !favButtonVisible.value!!
            }
        }
    }

    fun resetError(){
        exception.value = null
    }
}