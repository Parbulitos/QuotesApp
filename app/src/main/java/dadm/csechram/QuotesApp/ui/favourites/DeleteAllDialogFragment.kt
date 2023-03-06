package dadm.csechram.QuotesApp.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DeleteAllDialogFragment(private val actionButton: ButtonActionInterface): DialogFragment() {
    interface ButtonActionInterface{
        fun positiveAction()
        fun negativeAction()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Delete all favourite quotations?")
            .setMessage("Do you really want to delete all quotations?")
            .setPositiveButton("Delete") {_, _ -> actionButton.positiveAction() }
            .setNegativeButton("Cancel"){_, _ -> actionButton.negativeAction()}
            .create()
    }
}