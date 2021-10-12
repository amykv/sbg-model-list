package com.arasvitkus.sbgmodellist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arasvitkus.sbgmodellist.R
import com.arasvitkus.sbgmodellist.data.db.entities.ModelItem
import com.arasvitkus.sbgmodellist.ui.modellist.ModelViewModel
import kotlinx.android.synthetic.main.model_item.view.*

class ModelItemAdapter(
    var items: List<ModelItem>,
    private val viewModel: ModelViewModel
): RecyclerView.Adapter<ModelItemAdapter.ModelViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_item, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val curModelItem = items[position]

        holder.itemView.tvName.text = curModelItem.name
        holder.itemView.tvAmount.text = "${curModelItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curModelItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curModelItem.amount++
            viewModel.upsert(curModelItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(curModelItem.amount > 0) {
                curModelItem.amount--
                viewModel.upsert(curModelItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //changed ending from .root to .rootView. Not sure if necessary.
    inner class ModelViewHolder(val binding: View): RecyclerView.ViewHolder(binding.rootView)
}