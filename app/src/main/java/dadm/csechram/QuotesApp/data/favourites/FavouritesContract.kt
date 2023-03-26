package dadm.csechram.QuotesApp.data.favourites

object FavouritesContract {
    val dataBase: String = "FavouriteQuotesDataBase"
    object tableName {
        const val tableName: String = "FavouriteQuotes"
        const val idColumn: String = "idColumn"
        const val quoteColumn: String = "textColumn"
        const val authorColumn: String = "authorColumn"
    }
}