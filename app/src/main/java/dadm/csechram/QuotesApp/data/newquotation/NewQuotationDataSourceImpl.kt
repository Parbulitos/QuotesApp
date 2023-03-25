package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.data.newquotation.model.QuotationDto
import dadm.csechram.QuotesApp.domain.model.Quotation
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(private val retrofit: Retrofit): NewQuotationDataSource {
    interface NewQuotationRetrofit{
        @GET("api/1.0/?method=getQuote&format=json&lang=en")
        suspend fun getQuotation(): Response<QuotationDto>
    }

    private val retrofitQuotationService = retrofit.create(NewQuotationRetrofit::class.java)
    override suspend fun getQuotation(): Response<QuotationDto> {
        return try {
                    retrofitQuotationService.getQuotation()
                } catch (e: Exception) {
                    Response.error(400, ResponseBody.create(MediaType.parse("text/plain"), e.toString()))
                }

        /*try {
            return retrofitQuotationService.getQuotation()
        }catch (e: Exception){
            return Response.error(404, ResponseBody.create(MediaType.parse("text/plain"), e.toString()) )
        }*/
    }
}