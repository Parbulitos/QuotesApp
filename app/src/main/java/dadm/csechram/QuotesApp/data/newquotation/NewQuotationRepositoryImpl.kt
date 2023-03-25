package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(private val dataSource: NewQuotationDataSource) : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        return dataSource.getQuotation()
    }
}