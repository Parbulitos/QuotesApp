package dadm.csechram.QuotesApp.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable.TABLE_NAME
import dadm.csechram.QuotesApp.data.favourites.FavouritesContract

@Entity(tableName = FavouritesContract.tableName.tableName)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = FavouritesContract.tableName.idColumn)
    val id: String,
    @ColumnInfo(name = FavouritesContract.tableName.quoteColumn)
    val quote: String,
    @ColumnInfo(name = FavouritesContract.tableName.authorColumn)
    val author: String) {

}