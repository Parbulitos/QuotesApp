package dadm.csechram.QuotesApp.ui.newquotation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dadm.csechram.QuotesApp.ui.newquotation.NewQuotationViewModel
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentNewQuotationBinding


class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation), MenuProvider {
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
            binding.tvGreetings.visibility = if(it) View.VISIBLE else View.INVISIBLE
            binding.tvQuote.visibility = if(it) View.INVISIBLE else View.VISIBLE
            binding.flotatingFavButton.visibility = if(it) View.INVISIBLE else View.VISIBLE
        }
        viewModel.favButtonVisibleGetter.observe(viewLifecycleOwner){isFavVisible ->
            if(isFavVisible){
                binding.flotatingFavButton.setImageResource(R.drawable.add_favourite_vector)
            }else{
                binding.flotatingFavButton.setImageResource(R.drawable.favourites_vector)
            }

        }
        binding.flotatingFavButton.setOnClickListener{
            viewModel.addToFavourites()
        }
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getNewQuotation()
        }
        requireActivity().addMenuProvider(this,viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_new_quotation, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.refreshItem){
            viewModel.getNewQuotation()
            return true
        }else{
            return false
        }

    }
}