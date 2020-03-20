package com.tonacastro.gnomos.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tonacastro.gnomos.R
import com.tonacastro.gnomos.databinding.ItemGnomoBinding
import com.tonacastro.gnomos.databinding.ItemTitleBinding
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-20
 * @updated on
 * @modified by
 */
class GenericListAdapter :  RecyclerView.Adapter<GenericListAdapter.GnomoViewHolder>(){


    var itemList: List<String> = arrayListOf()

    fun notifyChanges(list: List<String>){
        itemList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GnomoViewHolder {
        val binding = DataBindingUtil.inflate<ItemTitleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_title, parent, false)
        return GnomoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

    override fun onBindViewHolder(holder: GnomoViewHolder, position: Int) {
        val itemSelected = itemList.get(position)

        holder.cellGnomoBinding.itemTittleTvtittle.text = itemSelected


    }

    class GnomoViewHolder(view: ItemTitleBinding) :
        RecyclerView.ViewHolder(view.getRoot()) {
        var cellGnomoBinding: ItemTitleBinding
        init {
            cellGnomoBinding = view
        }
    }
}