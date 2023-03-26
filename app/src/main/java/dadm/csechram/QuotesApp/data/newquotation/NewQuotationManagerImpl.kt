package dadm.csechram.QuotesApp.data.newquotation

import dadm.csechram.QuotesApp.data.settings.SettingsRepository
import dadm.csechram.QuotesApp.domain.model.Quotation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationManagerImpl @Inject constructor(val settingsRepository: SettingsRepository, val newQuotationRepository: NewQuotationRepository): NewQuotationManager {
    private lateinit var language: String
    init {
        CoroutineScope(SupervisorJob()).launch {
            settingsRepository.getLanguage().collect { languageCode ->
                language = languageCode
            }
        }
    }

    override suspend fun getNewQuotation(): Result<Quotation> {
        return newQuotationRepository.getNewQuotation(language)
    }
}