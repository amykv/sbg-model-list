package com.arasvitkus.sbgmodellist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ModelItem)

    @Delete
    suspend fun delete(item: ModelItem)

    @Query("SELECT * FROM model_items")
    fun getAllModelItems(): LiveData<List<ModelItem>>
}