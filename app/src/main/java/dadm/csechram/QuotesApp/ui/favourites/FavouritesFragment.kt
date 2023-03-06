package dadm.csechram.QuotesApp.ui.favourites

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment(R.layout.fragment_favourites){
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavouritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)
        val adapter = QuotationListAdapter()
        binding.recyclerViewFavourites.adapter = adapter
        viewModel.favouriteListGetter.observe(viewLifecycleOwner){list->
            adapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}