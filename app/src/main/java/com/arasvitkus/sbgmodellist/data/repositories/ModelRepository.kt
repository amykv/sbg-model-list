package com.arasvitkus.sbgmodellist.data.repositories

import com.arasvitkus.sbgmodellist.data.db.ModelDatabase
import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem

class ModelRepository (
    private val db: ModelDatabase
) {
    suspend fun upsert(item: ModelItem) = db.getModelDao().upsert(item)

    suspend fun delete(item: ModelItem) = db.getModelDao().delete(item)

    fun getAllModelItems() = db.getModelDao().getAllModelItems()
}