package dadm.csechram.QuotesApp.ui.newquotation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dadm.csechram.QuotesApp.ui.newquotation.NewQuotationViewModel
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentNewQuotationBinding


class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation) {
    private var _binding: FragmentNewQuotationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewQuotationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
        viewModel.userNameGetter.observe(viewLifecycleOwner){username: String ->
            binding.tvGreetings.text = getString(R.string.greetings, username)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}