package dadm.csechram.QuotesApp.ui.favourites

import androidx.lifecycle.*
import dadm.csechram.QuotesApp.data.favourites.FavouritesRepository
import dadm.csechram.QuotesApp.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val favouritesRepository: FavouritesRepository): ViewModel() {
    val favouriteListGetter : LiveData<List<Quotation>> get(){
        return favouritesRepository.getAllQuotations().asLiveData()
    }
    val isDeleteAllVisible = favouriteListGetter.map{list ->
        list.isNotEmpty()
    }
    /*
    private fun getFavouriteQuotations() : List<Quotation>{
        return listOf(
            Quotation("1","I have no special talent. I am only passionately curious.","Albert Einstein"),
            Quotation("2","El que la sigue la consige","Anonymus")
        ) + (3..20).map{
            val id = (0..99).random().toString()
            Quotation(id,"Quotation $id","Author $id")
        }
    }

    fun deleteAllQuotations(){
        favouriteList.value = emptyList()
    }

    fun deleteQuotationAtPosition(position: Int){
        var favouritesListCopy = favouriteList.value?.toMutableList()
        favouritesListCopy?.removeAt(position)
        favouriteList.value = favouritesListCopy?: emptyList()
    }*/

}