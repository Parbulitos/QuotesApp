package dadm.csechram.QuotesApp.ui.favourites

import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.MediaRouter.SimpleCallback
import android.net.Uri
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dadm.csechram.QuotesApp.R
import dadm.csechram.QuotesApp.databinding.FragmentFavouritesBinding

class FavouritesFragment : Fragment(R.layout.fragment_favourites), DeleteAllDialogFragment.ButtonActionInterface, MenuProvider{
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavouritesViewModel by viewModels()
    private val touchHelper : ItemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.END){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            viewModel.deleteQuotationAtPosition(viewHolder.adapterPosition)
        }

        override fun isLongPressDragEnabled(): Boolean {
            return false
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return true
        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)
        val adapter = QuotationListAdapter(object: QuotationListAdapter.ItemClicked{
            override fun onClick(author: String) {
                if(author.equals("Anonymus")){
                    Snackbar.make(requireContext(),view,"It's not possible to gather information",Snackbar.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=$author"))
                    try{
                        startActivity(intent)
                    }catch (e : ActivityNotFoundException){
                        Snackbar.make(requireContext(),view,"It's not possible to execute this action",Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        })
        binding.recyclerViewFavourites.adapter = adapter
        viewModel.favouriteListGetter.observe(viewLifecycleOwner){list->
            adapter.submitList(list)
        }
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner){isVisible ->
            if(!isVisible) requireActivity().invalidateMenu()
        }
        touchHelper.attachToRecyclerView(binding.recyclerViewFavourites)
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