package dadm.csechram.QuotesApp.ui.newquotation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentNewQuotationBinding


class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation) {
    private var _binding: FragmentNewQuotationBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}