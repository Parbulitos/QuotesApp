package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import dadm.csechram.QuotesApp.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    suspend fun addQuotation(quote: Quotation)
    suspend fun deleteQuotation(quote: Quotation)
    fun getAllQuotations() : Flow<List<Quotation>>
    fun getQuotationById(id: String) : Flow<Quotation>
    suspend fun deleteAllQuotations()
}