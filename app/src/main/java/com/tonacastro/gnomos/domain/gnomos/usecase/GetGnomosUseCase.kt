package com.tonacastro.gnomos.domain.gnomos.usecase

import androidx.lifecycle.LiveData
import com.tonacastro.gnomos.data.gnomos.repository.GnomosRepository
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
class GetGnomosUseCase(val repository: GnomosRepository) {
    suspend fun getGnomosList():LiveData<List<GnomoModel>>{
       return repository.getListGnomos()
    }
}