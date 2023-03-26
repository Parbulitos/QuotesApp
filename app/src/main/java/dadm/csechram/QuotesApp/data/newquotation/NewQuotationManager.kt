package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation

interface NewQuotationManager {
    suspend fun getNewQuotation(): Result<Quotation>
}