package com.tonacastro.gnomos.domain.gnomos.repository

import androidx.lifecycle.LiveData
import com.tonacastro.gnomos.domain.gnomos.model.GenericResponse
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
interface IGnomosRepository {

    suspend fun getListGnomos(): LiveData<List<GnomoModel>>

    suspend fun getGnomo(id: Int): LiveData<List<GnomoModel?>>

    suspend fun insertGnomo(gnomo: GnomoModel): LiveData<GenericResponse>
}