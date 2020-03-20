package com.tonacastro.gnomos.data.gnomos.network.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonacastro.gnomos.data.gnomos.network.IListGnomosNetwork
import com.tonacastro.gnomos.data.gnomos.network.response.BrastlewarkListResponse
import com.tonacastro.gnomos.data.network.IResponse
import com.tonacastro.gnomos.data.network.NetworkConnectionBase
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
class GnomosNetworkConnection : NetworkConnectionBase() {
   suspend fun getGnomos() : BrastlewarkListResponse {
        val gnomosNetwork = retrofit.create(IListGnomosNetwork::class.java)
       return  gnomosNetwork.getGnomos()
   }

}