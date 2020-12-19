package com.example.dentalapp3.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.DialogFragment

class QuitDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Вы уверены, что хотите закрыть приложение?")
                .setPositiveButton("Да") { _, _ ->
                    this.activity?.let { it1 -> finishAffinity(it1) }
                }
                .setNegativeButton("Нет") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}