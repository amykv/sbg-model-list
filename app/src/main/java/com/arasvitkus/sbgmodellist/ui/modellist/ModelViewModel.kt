package com.arasvitkus.sbgmodellist.ui.modellist

import androidx.lifecycle.ViewModel
import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem
import com.arasvitkus.sbgmodellist.data.repositories.ModelRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModelViewModel(
    private val repository: ModelRepository
): ViewModel() {

    //Dispatchers.Main - create a new coroutine, have to tell Kotlin what context to start it.
    //Want to start it in Main thread
    fun upsert(item: ModelItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ModelItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllModelItems() = repository.getAllModelItems()
}