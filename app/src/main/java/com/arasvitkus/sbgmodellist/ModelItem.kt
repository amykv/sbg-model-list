package com.arasvitkus.sbgmodellist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data  = kotlin compiler - to hold data
@Entity(tableName = "model_items")
data class ModelItem(
    @ColumnInfo(name = "model_name")
    var name: String,
    @ColumnInfo(name = "model_amount")
    var amount: Int) {

    //Rooms will auto genearte ID's instead of manually
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}