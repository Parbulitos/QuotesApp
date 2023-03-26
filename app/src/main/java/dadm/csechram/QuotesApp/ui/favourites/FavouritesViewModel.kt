package dadm.csechram.QuotesApp.ui.favourites

import androidx.lifecycle.*
import dadm.csechram.QuotesApp.data.favourites.FavouritesRepository
import dadm.csechram.QuotesApp.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val favouritesRepository: FavouritesRepository): ViewModel() {

    val favouriteListGetter : LiveData<List<Quotation>> get(){
        return favouritesRepository.getAllQuotes().asLiveData()
    }
    /*
    val isDeleteAllVisible = favouriteList.map{list ->
        list.isNotEmpty()
    }*/
/*
    fun deleteAllQuotations(){
        favouriteList.value = emptyList()
    }

    fun deleteQuotationAtPosition(position: Int){
        var favouritesListCopy = favouriteList.value?.toMutableList()
        favouritesListCopy?.removeAt(position)
        favouriteList.value = favouritesListCopy?: emptyList()
    }*/

}