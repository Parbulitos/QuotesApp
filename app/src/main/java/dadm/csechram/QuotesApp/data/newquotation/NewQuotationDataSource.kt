package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.data.newquotation.model.QuotationDto
import retrofit2.Response

interface NewQuotationDataSource {
    suspend fun getQuotation(): Response<QuotationDto>
}