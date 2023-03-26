package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(val favouritesDao: FavouritesDao): FavouritesDataSource {

    override suspend fun addQuote(quote: QuotationDto) {
        favouritesDao.addQuote(quote)
    }

    override suspend fun removeQuote(quote: QuotationDto) {
        favouritesDao.removeQuote(quote)
    }

    override fun getAllQuotes(): Flow<List<QuotationDto>> {
        return favouritesDao.getAllQuotes()
    }

    override fun getQuoteById(id: String): Flow<QuotationDto> {
        return favouritesDao.getQuoteById(id)
    }

    override fun deleteAllQuotes() {
        favouritesDao.deleteAllQuotes()
    }
}