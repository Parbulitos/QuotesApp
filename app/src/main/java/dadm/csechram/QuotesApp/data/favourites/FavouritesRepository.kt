package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    suspend fun addQuote(quote: Quotation)
    suspend fun removeQuote(quote: Quotation)
    fun getAllQuotes() : Flow<List<Quotation>>
    fun getQuoteById(id: String) : Flow<Quotation>
    fun deleteAllQuotes()
}