package com.tonacastro.gnomos.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonacastro.gnomos.data.database.GnomosDatabase
import com.tonacastro.gnomos.data.gnomos.repository.GnomosRepository
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.domain.gnomos.usecase.GetGnomosUseCase
import kotlinx.coroutines.launch

class MainViewModel (val database: GnomosDatabase): ViewModel() {

    val repository = GnomosRepository(database)
    val useCase = GetGnomosUseCase(repository)

    private var gnomosLiveData: MutableLiveData<List<GnomoModel>?> = MutableLiveData()

    init {
        loadGnomos()
    }

    fun getGnomosLiveData(): LiveData<List<GnomoModel>?> {
        return gnomosLiveData
    }

    fun loadGnomos() {
        viewModelScope.launch {
            gnomosLiveData.value = useCase.getGnomosList().value?.subList(0,10)
        }
    }
}
