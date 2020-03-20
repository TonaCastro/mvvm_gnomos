package com.tonacastro.gnomos.data.gnomos.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonacastro.gnomos.data.database.GnomosDatabase
import com.tonacastro.gnomos.data.gnomos.model.toDomainModel
import com.tonacastro.gnomos.data.gnomos.network.request.GnomosNetworkConnection
import com.tonacastro.gnomos.data.gnomos.network.response.toEntityBrastlewark
import com.tonacastro.gnomos.domain.gnomos.model.GenericResponse
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.domain.gnomos.repository.IGnomosRepository

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
class GnomosRepository(private val database: GnomosDatabase): IGnomosRepository {
    override suspend fun getListGnomos(): LiveData<List<GnomoModel>> {
        val listGnomo = arrayListOf<GnomoModel>()
        val liveData = MutableLiveData<List<GnomoModel>>()
        val network = GnomosNetworkConnection()
        network.onCreateConnection(
                "https://raw.githubusercontent.com/rrafols/mobile_test/master/")
        network.getGnomos().brastlewark.forEach {
            database.gnomosDao.insertGnomo(it.toEntityBrastlewark())
        }
        database.gnomosDao.getGnomos()?.forEach {
            listGnomo.add(it.toDomainModel())
        }
        liveData.value = listGnomo
       return liveData
    }


    override suspend fun getGnomo(id: Int): LiveData<List<GnomoModel?>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun insertGnomo(gnomo: GnomoModel): LiveData<GenericResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}