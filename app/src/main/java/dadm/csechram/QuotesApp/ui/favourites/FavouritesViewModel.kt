package dadm.csechram.QuotesApp.ui.favourites

import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dadm.csechram.QuotesApp.domain.model.Quotation
import dadm.csechram.QuotesApp.ui.newquotation.NewQuotationViewModel

class FavouritesViewModel : ViewModel() {
    private val favouriteList : MutableLiveData<List<Quotation>> = MutableLiveData<List<Quotation>>(getFavouriteQuotations())


    val favouriteListGetter : LiveData<List<Quotation>> get(){
        return this.favouriteList
    }
    val isDeleteAllVisible = Transformations.map(favouriteList){list ->
        list.isNotEmpty()
    }

    private fun getFavouriteQuotations() : List<Quotation>{
        return (1..20).map {
            val id = (0..50).random().toString()
            Quotation(id,"Quotation $id","Author $id") }
    }

    fun deleteAllQuotations(){
        favouriteList.value = emptyList()
    }

    fun deleteQuotationAtPosition(position: Int){
        var favouritesListCopy = favouriteList.value?.toMutableList()
        favouritesListCopy?.removeAt(position)
        favouriteList.value = favouritesListCopy?: emptyList()
    }

}