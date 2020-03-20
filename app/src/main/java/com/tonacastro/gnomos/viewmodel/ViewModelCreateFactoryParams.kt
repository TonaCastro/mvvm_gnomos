package com.tonacastro.gnomos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tonacastro.gnomos.data.database.GnomosDatabase
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel
import com.tonacastro.gnomos.viewmodel.detail.DetailViewModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-20
 * @updated on
 * @modified by
 */
class ViewModelCreateFactoryParams (private val datasource: GnomosDatabase,
                                    private val param: Any
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when (modelClass){
            DetailViewModel::class.java -> return DetailViewModel(
                datasource,
                param as GnomoModel
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")

        }

    }
}