package dadm.csechram.QuotesApp.data.di

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

}