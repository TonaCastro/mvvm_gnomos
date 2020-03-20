package com.tonacastro.gnomos.view.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

import com.tonacastro.gnomos.R
import com.tonacastro.gnomos.data.database.GnomosDatabase
import com.tonacastro.gnomos.databinding.DetailFragmentBinding
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.view.adapters.GnomoListAdapter
import com.tonacastro.gnomos.viewmodel.ViewModelCreateFactoryParams
import com.tonacastro.gnomos.viewmodel.detail.DetailViewModel
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment : Fragment() {

    private lateinit var gnomoDetail : GnomoModel

    private lateinit var adapter: GnomoListAdapter

    private lateinit var  binding: DetailFragmentBinding

    companion object {

        @JvmStatic
        fun newInstance(gnomo: GnomoModel): DetailFragment{
            return DetailFragment().apply {
                    this.gnomoDetail = gnomo
            }
        }
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.detail_fragment,
            container, false)
        binding.setLifecycleOwner(activity)
        binding.detailFragmentRvprofessions.setLayoutManager(
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        )
        binding.detailFragmentRvfriends.setLayoutManager(
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val gnomosDatabase = GnomosDatabase.getDatabase(activity!!.application)
        val factory = ViewModelCreateFactoryParams(gnomosDatabase, this.gnomoDetail)
        viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel
        viewModel.getGnomoLiveData().observe(viewLifecycleOwner,observerGnomo)
    }

    var observerGnomo = Observer<GnomoModel> {
        it?.let {
            context?.let {contextIt ->
                Glide.with(contextIt).load(it.imageUrl).centerCrop()
                    .error(R.drawable.ic_launcher_background).into(detail_fragment_imgmain)
            }

        }
    }

}
