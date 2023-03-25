package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.data.newquotation.model.toDomain
import dadm.csechram.QuotesApp.domain.model.Quotation
import dadm.csechram.QuotesApp.utils.NoInternetException
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject constructor(private val dataSource: NewQuotationDataSource, private val connectivityChecker: ConnectivityChecker) : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        if(connectivityChecker.isConnectionAvailable()){
            return dataSource.getQuotation(arrayOf("en","ru","xx").random()).toDomain()
        }else{
            return Result.failure(NoInternetException())
        }
    }
}