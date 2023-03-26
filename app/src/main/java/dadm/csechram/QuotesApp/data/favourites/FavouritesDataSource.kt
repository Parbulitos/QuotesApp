package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addQuotation(quote: QuotationDto)
    suspend fun deleteQuotation(quote: QuotationDto)
    fun getAllQuotations() : Flow<List<QuotationDto>>
    fun getQuotationById(id: String) : Flow<QuotationDto>
    fun deleteAllQuotations()
}