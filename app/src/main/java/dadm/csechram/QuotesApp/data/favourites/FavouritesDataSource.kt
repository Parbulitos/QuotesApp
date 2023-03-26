package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addQuote(quote: QuotationDto)
    suspend fun removeQuote(quote: QuotationDto)
    fun getAllQuotes() : Flow<List<QuotationDto>>
    fun getQuoteById(id: String) : Flow<QuotationDto>
    fun deleteAllQuotes()
}