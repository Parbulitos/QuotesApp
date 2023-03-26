package dadm.csechram.QuotesApp.ui.newquotation.di

import android.content.Context
import androidx.room.Room
import dadm.csechram.QuotesApp.data.favourites.FavouritesDao
import dadm.csechram.QuotesApp.data.favourites.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {
    @Provides
    @Singleton
    fun provideFavouritesDatabase(@ApplicationContext context : Context): FavouritesDatabase{
        return Room.databaseBuilder(context, FavouritesDatabase::class.java,"FavouriteQuotesDataBase").build()
    }
    @Provides
    fun provideFavouritesDao(favouritesDatabase: FavouritesDatabase): FavouritesDao{
        return favouritesDatabase.favouritesDao()
    }
}