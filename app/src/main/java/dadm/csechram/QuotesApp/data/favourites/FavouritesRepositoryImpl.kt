package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.toDto
import dadm.csechram.QuotesApp.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(val favouritesDataSource: FavouritesDataSource): FavouritesRepository {
    override suspend fun addQuotation(quote: Quotation) {
        favouritesDataSource.addQuotation(quote.toDto())
    }

    override suspend fun deleteQuotation(quote: Quotation) {
        favouritesDataSource.deleteQuotation(quote.toDto())
    }

    override fun getAllQuotations(): Flow<List<Quotation>> {
        return favouritesDataSource.getAllQuotations().map{quotationDtoList ->
            quotationDtoList.map { quotationDto ->
                Quotation(
                    quote = quotationDto.quote,
                    author = quotationDto.author,
                    id = quotationDto.id)
            }
        }
    }

    override fun getQuotationById(id: String): Flow<Quotation> {
        return favouritesDataSource.getQuotationById(id).map { quotationDto ->
            Quotation(
                quote = quotationDto.quote,
                author = quotationDto.author,
                id = quotationDto.id)
        }
    }

    override suspend fun deleteAllQuotations() {
        favouritesDataSource.deleteAllQuotations()
    }
}