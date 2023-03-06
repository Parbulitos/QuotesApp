package dadm.csechram.QuotesApp.ui.favourites

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment(R.layout.fragment_favourites), DeleteAllDialogFragment.ButtonActionInterface, MenuProvider{
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
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner){isVisible ->
            if(!isVisible) requireActivity().invalidateMenu()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun positiveAction() {
        viewModel.deleteAllQuotations()
    }

    override fun negativeAction() {}
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.deleteMenuItem){
            DeleteAllDialogFragment(this).show(childFragmentManager, null)
            return true
        }else{
            return false
        }
    }

    override fun onPrepareMenu(menu: Menu) {
        super.onPrepareMenu(menu)
        menu.findItem(R.id.deleteMenuItem).isEnabled = viewModel.isDeleteAllVisible.value!!
    }
}