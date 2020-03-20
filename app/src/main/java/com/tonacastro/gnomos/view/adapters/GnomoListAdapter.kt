package com.tonacastro.gnomos.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.tonacastro.gnomos.R
import com.tonacastro.gnomos.databinding.ItemGnomoBinding
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
class GnomoListAdapter( private val callback : (Any) -> Unit) :
    RecyclerView.Adapter<GnomoListAdapter.GnomoListViewHolder>() {

    var gnomoList: List<GnomoModel> = arrayListOf()
    lateinit var contextMain: Context;

    fun loadContext(context: Context){
        contextMain = context
    }

    fun notifyChanges(list: List<GnomoModel>){
        gnomoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GnomoListViewHolder {
        val binding = DataBindingUtil.inflate<ItemGnomoBinding>(LayoutInflater.from(parent.context),
            R.layout.item_gnomo, parent, false)
        return GnomoListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gnomoList.size
    }

    override fun onBindViewHolder(holder: GnomoListViewHolder, position: Int) {
        val itemSelected = gnomoList.get(position)
        holder.cellGnomoBinding.gnomo = itemSelected
        Glide.with(contextMain).load(itemSelected.imageUrl).centerCrop()
            .error(R.drawable.ic_launcher_background).into(holder.cellGnomoBinding.itemGnomoImgmain)
        holder.cellGnomoBinding.itemGnomoTbndetail.setOnClickListener {
            callback(itemSelected)
        }
    }

    class GnomoListViewHolder(view: ItemGnomoBinding) :
        RecyclerView.ViewHolder(view.getRoot()) {
        var cellGnomoBinding: ItemGnomoBinding
        init {
            cellGnomoBinding = view
        }
    }
}