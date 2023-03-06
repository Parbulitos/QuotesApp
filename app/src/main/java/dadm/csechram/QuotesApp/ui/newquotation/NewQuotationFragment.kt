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
        //Observe changes on userName
        viewModel.userNameGetter.observe(viewLifecycleOwner){username: String ->
            binding.tvGreetings.text = getString(R.string.greetings, username)
        }
        viewModel.quotationGetter.observe(viewLifecycleOwner){quote ->
            if(quote.author.equals("")){
                binding.tvQuote.text = getString(R.string.quotePresentation, "Anonymus", quote.quote)
            }
            binding.tvQuote.text = getString(R.string.quotePresentation, quote.author, quote.quote)
        }
        viewModel.isRefreshingGetter.observe(viewLifecycleOwner){isLoading ->
            binding.swipeToRefresh.isRefreshing = isLoading
        }
        viewModel.isGreetingsVisible.observe(viewLifecycleOwner){
            binding.tvGreetings.visibility = if (it) View.VISIBLE else View.INVISIBLE
            binding.tvQuote.visibility = if(it) View.INVISIBLE else View.VISIBLE
        }
        binding.swipeToRefresh.setOnRefreshListener {
            getNewQuotation()
        }
    }
    fun getNewQuotation(){
        viewModel.getNewQuotation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}