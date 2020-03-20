package com.tonacastro.gnomos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tonacastro.gnomos.data.database.GnomosDatabase
import com.tonacastro.gnomos.viewmodel.main.MainViewModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
class ViewModelCreateFactory(private val datasource: GnomosDatabase
                             ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        when (modelClass){
            MainViewModel::class.java -> return MainViewModel(datasource ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")

        }

    }
}

