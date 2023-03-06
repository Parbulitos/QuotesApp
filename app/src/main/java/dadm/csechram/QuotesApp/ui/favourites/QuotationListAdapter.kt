package dadm.csechram.QuotesApp.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dadm.csechram.QuotesApp.domain.model.Quotation
import dadm.csechram.QuotesApp.databinding.QuotationItemBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class QuotationListAdapter : ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff) {

    object QuotationDiff : DiffUtil.ItemCallback<Quotation>(){
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding : QuotationItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(quotation : Quotation){
                binding.authorMaterialTextView.text = quotation.author
                binding.quoteMaterialTextView.text = quotation.quote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(QuotationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}