package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.data.newquotation.model.QuotationDto
import dadm.csechram.QuotesApp.domain.model.Quotation
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(private val retrofit: Retrofit): NewQuotationDataSource {
    interface NewQuotationRetrofit{
        @GET("api/1.0/?method=getQuote&format=json")
        suspend fun getQuotation(@Query("lang")language: String): Response<QuotationDto>
    }

    private val retrofitQuotationService = retrofit.create(NewQuotationRetrofit::class.java)
    override suspend fun getQuotation(language: String): Response<QuotationDto> {
        return try {
                    retrofitQuotationService.getQuotation(language)
                } catch (e: Exception) {
                    Response.error(400, ResponseBody.create(MediaType.parse("text/plain"), e.toString()))
                }
    }
}