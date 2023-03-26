package dadm.csechram.QuotesApp.data.settings

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsDataSourceImpl @Inject constructor(val sharedPreferences: SharedPreferences): SettingsDataSource {
    companion object{
        val userNameKey = "userNameInput"
        val userLanguage = "languageList"
    }

    private fun getUsernamePreference() = sharedPreferences.getString(userNameKey,"") ?:""

    private fun getLanguagePreference() = sharedPreferences.getString(userLanguage,"en") ?:""

    override fun getUsername(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (userNameKey == key) {
                    trySend(getUsernamePreference())
                }
            }
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        trySend(getUsernamePreference())
        awaitClose {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }.flowOn(Dispatchers.IO)

    override fun getLanguage(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (userLanguage == key) {
                    trySend(getLanguagePreference())
                }
            }
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        trySend(getLanguagePreference())
        awaitClose {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }.flowOn(Dispatchers.IO)
}