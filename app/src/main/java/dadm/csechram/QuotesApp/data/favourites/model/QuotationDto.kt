package dadm.csechram.QuotesApp.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = "idColumn")
    val id: String,
    @ColumnInfo(name = "quoteColumn")
    val quote: String,
    @ColumnInfo(name = "authorColumn")
    val author: String) {

}