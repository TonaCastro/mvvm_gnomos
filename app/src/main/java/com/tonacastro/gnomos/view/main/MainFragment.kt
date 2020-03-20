package com.tonacastro.gnomos.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonacastro.gnomos.R
import com.tonacastro.gnomos.data.database.GnomosDatabase.Companion.getDatabase
import com.tonacastro.gnomos.databinding.MainFragmentBinding
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.view.adapters.GnomoListAdapter
import com.tonacastro.gnomos.viewmodel.ViewModelCreateFactory
import com.tonacastro.gnomos.viewmodel.main.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    //region Members
    private lateinit var viewModel: MainViewModel

    private lateinit var callbackMain: GnomoSelectedListener

    private lateinit var adapter: GnomoListAdapter

    //endregion

    //region system methods

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val  binding: MainFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.main_fragment,container,false)
        binding.setLifecycleOwner (activity)
        binding.listGnomoFragmentRvcontainer.setLayoutManager(
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = GnomoListAdapter(){
            doClick(it as GnomoModel)
        }
        context?.let {
            adapter.loadContext(it)
        }
        list_gnomo_fragment_rvcontainer.adapter = adapter
        val gnomosDatabase = getDatabase(activity!!.application)
        val factory = ViewModelCreateFactory(gnomosDatabase)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.getGnomosLiveData().observe(viewLifecycleOwner,observerList)
    }

    //endregion

    //region my methods

    fun setGnomoSelectedListener(callback: GnomoSelectedListener) {
        this.callbackMain = callback
    }

    //endregion
    //region Observers

    var observerList = Observer<List<GnomoModel>?> {
        it?.let {
            adapter.notifyChanges(it)
        }
    }

    fun doClick(item:GnomoModel) {
        this.callbackMain.gnomoSelected(item)
    }

    //

    //region Interface callback

    interface GnomoSelectedListener {
        fun gnomoSelected(service: GnomoModel)
    }
    //endregion
}
