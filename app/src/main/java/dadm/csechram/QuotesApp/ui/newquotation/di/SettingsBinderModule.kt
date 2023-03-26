package dadm.csechram.QuotesApp.ui.newquotation.di

import dadm.csechram.QuotesApp.data.newquotation.NewQuotationDataSource
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationDataSourceImpl
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepository
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepositoryImpl
import dadm.csechram.QuotesApp.data.settings.SettingsDataSource
import dadm.csechram.QuotesApp.data.settings.SettingsDataSourceImpl
import dadm.csechram.QuotesApp.data.settings.SettingsRepository
import dadm.csechram.QuotesApp.data.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
    @Binds
    abstract fun bindSettingsRepository(repository: SettingsRepositoryImpl) : SettingsRepository
    @Binds
    abstract fun bindSettingsDataSource(datasource: SettingsDataSourceImpl) : SettingsDataSource
}