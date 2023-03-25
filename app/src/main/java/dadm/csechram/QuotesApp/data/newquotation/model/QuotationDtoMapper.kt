package dadm.csechram.QuotesApp.data.newquotation.model

import dadm.csechram.QuotesApp.domain.model.Quotation
import retrofit2.Response
import java.io.IOException

fun QuotationDto.toDomain() = Quotation(id = quoteLink, quote = quoteText, author = quoteAuthor)

fun Response<QuotationDto>.toDomain() = if (isSuccessful) Result.success((body() as QuotationDto).toDomain()) else Result.failure(IOException())
