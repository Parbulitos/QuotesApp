package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl: NewQuotationRepository {
    @Inject
    override suspend fun getNewQuotation(): Result<Quotation> {
        val num = (0..9).random()
        if(num != 0){
            var quote = Quotation("$num","Quote: $num", "Author $num")
            return Result.success(quote)
        }else{
            return Result.failure(Exception("Error getting the quote"))
        }
    }
}