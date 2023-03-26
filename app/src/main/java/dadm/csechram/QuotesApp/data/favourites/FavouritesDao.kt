package dadm.csechram.QuotesApp.data.favourites

import android.app.DownloadManager.COLUMN_ID
import androidx.room.*
import androidx.room.RoomMasterTable.TABLE_NAME
import dadm.csechram.QuotesApp.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotation(quote: QuotationDto)
    @Delete
    suspend fun deleteQuotation(quote: QuotationDto)
    @Query("SELECT * FROM ${FavouritesContract.tableName.tableName}")
    fun getAllQuotations() : Flow<List<QuotationDto>>
    @Query("SELECT * FROM ${FavouritesContract.tableName.tableName} WHERE idColumn = :id")
    fun getQuotationById(id:String) : Flow<QuotationDto>
    @Query("DELETE FROM ${FavouritesContract.tableName.tableName}")
    fun deleteAllQuotations()

}