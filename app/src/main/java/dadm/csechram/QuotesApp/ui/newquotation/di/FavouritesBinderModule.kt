package dadm.csechram.QuotesApp.ui.newquotation.di

import dadm.csechram.QuotesApp.data.favourites.FavouritesDataSource
import dadm.csechram.QuotesApp.data.favourites.FavouritesDataSourceImpl
import dadm.csechram.QuotesApp.data.favourites.FavouritesRepository
import dadm.csechram.QuotesApp.data.favourites.FavouritesRepositoryImpl
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationDataSourceImpl
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {
    @Binds
    abstract fun bindFavouritesRepository(repository: FavouritesRepositoryImpl) : FavouritesRepository
    @Binds
    abstract fun bindFavouritesDataSource(datasource: FavouritesDataSourceImpl) : FavouritesDataSource
}