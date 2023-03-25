package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor() : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        var num = (0..9).random()
        if(num != 0){
            return Result.success(Quotation("$num","Quote: $num", "Author $num"))
        }else{
            return Result.failure(Exception("Error getting the quote"))
        }
    }
}