package dadm.csechram.QuotesApp.data.favourites.model

import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import dadm.csechram.QuotesApp.domain.model.Quotation

fun QuotationDto.toDomain() = Quotation(id = id, quote = quote, author = author)

fun Quotation.toDto() = QuotationDto(id = id, quote = quote, author = author)