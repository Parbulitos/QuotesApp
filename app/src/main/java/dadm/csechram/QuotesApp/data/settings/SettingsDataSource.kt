package dadm.csechram.QuotesApp.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUsername(): Flow<String>
}