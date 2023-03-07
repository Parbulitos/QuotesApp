package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation() : Result<Quotation>
}