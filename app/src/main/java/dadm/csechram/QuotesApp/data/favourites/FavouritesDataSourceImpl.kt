package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(val favouritesDao: FavouritesDao): FavouritesDataSource {

    override suspend fun addQuotation(quote: QuotationDto) {
        favouritesDao.addQuotation(quote)
    }

    override suspend fun deleteQuotation(quote: QuotationDto) {
        favouritesDao.deleteQuotation(quote)
    }

    override fun getAllQuotations(): Flow<List<QuotationDto>> {
        return favouritesDao.getAllQuotations()
    }

    override fun getQuotationById(id: String): Flow<QuotationDto> {
        return favouritesDao.getQuotationById(id)
    }

    override suspend fun deleteAllQuotations() {
        favouritesDao.deleteAllQuotations()
    }
}