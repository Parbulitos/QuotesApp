package dadm.csechram.QuotesApp.ui.newquotation.di

import dadm.csechram.QuotesApp.data.newquotation.NewQuotationDataSource
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationDataSourceImpl
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepository
import dadm.csechram.QuotesApp.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(repository: NewQuotationRepositoryImpl) : NewQuotationRepository
    @Binds
    abstract fun bindNewQuotationDataSource(datasource: NewQuotationDataSourceImpl) : NewQuotationDataSource
}