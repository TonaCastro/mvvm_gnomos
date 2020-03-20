package com.tonacastro.gnomos.viewmodel.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonacastro.gnomos.data.database.GnomosDatabase
import com.tonacastro.gnomos.data.gnomos.repository.GnomosRepository
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.domain.gnomos.usecase.GetGnomosUseCase
import kotlinx.coroutines.launch

class DetailViewModel(val database: GnomosDatabase,val gnomo: GnomoModel) : ViewModel() {

    val repository = GnomosRepository(database)
    val useCase = GetGnomosUseCase(repository)

    private var gnomosLiveData: MutableLiveData<GnomoModel> = MutableLiveData()

    init {
        loadGnomo()
    }

    fun getGnomoLiveData(): LiveData<GnomoModel> {
        return gnomosLiveData
    }

    fun loadGnomo() {
        gnomosLiveData.value = gnomo
    }
}
