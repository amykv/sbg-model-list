package com.arasvitkus.sbgmodellist.ui.modellist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arasvitkus.sbgmodellist.data.repositories.ModelRepository

class ModelViewModelFactory(
    private val repository: ModelRepository
): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ModelViewModel(repository) as T
    }
}