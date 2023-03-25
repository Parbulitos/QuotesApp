package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.domain.model.Quotation
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(): NewQuotationDataSource {
    override suspend fun getQuotation(): Result<Quotation> {
        var num = (0..9).random()
        if(num != 0){
            return Result.success(Quotation("$num","Quote: $num", "Author $num"))
        }else{
            return Result.failure(Exception("Error getting the quote"))
        }
    }
}