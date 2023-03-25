package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation

interface NewQuotationDataSource {
    suspend fun getQuotation(): Result<Quotation>
}