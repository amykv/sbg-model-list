package com.arasvitkus.sbgmodellist.ui.modellist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arasvitkus.sbgmodellist.R
import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem
import com.arasvitkus.sbgmodellist.other.ModelItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ModelViewModelFactory by instance()

    lateinit var viewModel: ModelViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Below is being replace by kodein
    /*    val database = ModelDatabase(this)
        val repository = ModelRepository(database)
        val factory = ModelViewModelFactory(repository)*/

        viewModel = ViewModelProvider(this, factory).get(ModelViewModel::class.java)

        val adapter = ModelItemAdapter(listOf(), viewModel)

        rvModelItems.layoutManager = LinearLayoutManager(this)
        rvModelItems.adapter = adapter

        //Working with ModelDao
        viewModel.getAllModelItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        //floating action button
        fab.setOnClickListener{
            AddModelItemDialog(this,
            object : AddDialogListener {
                override fun onAddButtonClicked(item: ModelItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}