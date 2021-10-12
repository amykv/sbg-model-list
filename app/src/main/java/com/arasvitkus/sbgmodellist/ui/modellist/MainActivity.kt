package com.arasvitkus.sbgmodellist.ui.modellist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arasvitkus.sbgmodellist.R
import com.arasvitkus.sbgmodellist.data.db.ModelDatabase
import com.arasvitkus.sbgmodellist.data.repositories.ModelRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ModelDatabase(this)
        val repository = ModelRepository(database)
        val factory = ModelViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(ModelViewModel::class.java)
    }
}