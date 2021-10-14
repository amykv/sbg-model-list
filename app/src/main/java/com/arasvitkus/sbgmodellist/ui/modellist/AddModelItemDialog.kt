package com.arasvitkus.sbgmodellist.ui.modellist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.arasvitkus.sbgmodellist.R
import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem
import kotlinx.android.synthetic.main.dialog_add_model_item.*

class AddModelItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_model_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val quantity = etQuantity.text.toString()

            if(name.isEmpty() || quantity.isEmpty()) {
                Toast.makeText(context, "Please enter information", Toast.LENGTH_SHORT).show()
            }

            val item = ModelItem(name, quantity.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener{
            cancel()
        }
    }
}