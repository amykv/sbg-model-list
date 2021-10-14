package com.arasvitkus.sbgmodellist.ui.modellist

import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ModelItem)
}