package com.arasvitkus.sbgmodellist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem

@Database(
    //refer to the class
    entities = [ModelItem::class],
    version = 1
)
abstract class ModelDatabase: RoomDatabase() {

    abstract fun getModelDao(): ModelDao

    companion object {
        @Volatile
        private var instance: ModelDatabase? = null
        private val LOCK = Any()

        //create instance of database
        //if instance is null, it will call synchronized, no other threads
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it} // if null, create it
        }//no other threads will access

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ModelDatabase::class.java, "ModelDB.db").build()
    }
}