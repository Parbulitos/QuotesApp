package dadm.csechram.QuotesApp.ui.settings

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentSettingsBinding

class settingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}