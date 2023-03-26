package dadm.csechram.QuotesApp.data.favourites

import android.app.DownloadManager.COLUMN_ID
import androidx.room.*
import androidx.room.RoomMasterTable.TABLE_NAME
import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuote(quote: QuotationDto)

    @Delete
    suspend fun removeQuote(quote: QuotationDto)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllQuotes() : Flow<List<QuotationDto>>

    @Query("SELECT * FROM $TABLE_NAME WHERE idColumn = :id")
    fun getQuoteById(id:String) : Flow<QuotationDto>

    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllQuotes()

}