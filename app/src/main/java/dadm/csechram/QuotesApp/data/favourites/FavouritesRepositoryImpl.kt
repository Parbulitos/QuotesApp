package dadm.csechram.QuotesApp.data.favourites

import dadm.csechram.QuotesApp.data.favourites.model.toDto
import dadm.csechram.QuotesApp.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(val favouritesDataSource: FavouritesDataSource): FavouritesRepository {
    override suspend fun addQuote(quote: Quotation) {
        favouritesDataSource.addQuote(quote.toDto())
    }

    override suspend fun removeQuote(quote: Quotation) {
        favouritesDataSource.removeQuote(quote.toDto())
    }

    override fun getAllQuotes(): Flow<List<Quotation>> {
        return favouritesDataSource.getAllQuotes().map{quotationDtoList ->
            quotationDtoList.map { quotationDto ->
                Quotation(
                    quote = quotationDto.quote,
                    author = quotationDto.author,
                    id = quotationDto.id)
            }
        }
    }

    override fun getQuoteById(id: String): Flow<Quotation> {
        return favouritesDataSource.getQuoteById(id).map { quotationDto ->
            Quotation(
                quote = quotationDto.quote,
                author = quotationDto.author,
                id = quotationDto.id)
        }
    }

    override fun deleteAllQuotes() {
        favouritesDataSource.deleteAllQuotes()
    }
}