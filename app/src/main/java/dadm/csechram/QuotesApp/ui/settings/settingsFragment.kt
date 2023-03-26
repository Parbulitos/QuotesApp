package dadm.csechram.QuotesApp.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import dadm.csechram.QuotesApp.R

class settingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_settings, rootKey)
    }

}