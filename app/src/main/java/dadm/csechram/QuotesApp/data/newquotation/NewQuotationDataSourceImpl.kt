package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.data.newquotation.model.QuotationDto
import dadm.csechram.QuotesApp.domain.model.Quotation
import dadm.csechram.QuotesApp.utils.NoInternetException
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(private val retrofit: Retrofit): NewQuotationDataSource {
    private val retrofitQuotationService = retrofit.create(NewQuotationretrofit::class.java)
    interface NewQuotationretrofit{
        @GET("api/1.0/?method=getQuote&format=json")
        abstract fun getQuotation(@Query("lang") language: String): Response<QuotationDto>
    }

    override suspend fun getQuotation(language: String): Response<QuotationDto> {
        return try {
            retrofitQuotationService.getQuotation(language)
        } catch (e: Exception) {
            Response.error(
                400, // Could be any other code and text, because we are not using it
                ResponseBody.create(MediaType.parse("text/plain"), e.toString())
            )
        }
    }
}