package com.tonacastro.gnomos.data.gnomos.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tonacastro.gnomos.data.gnomos.model.BrastlewarkEntity

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
@Dao
interface MasterGnomosDAO {

    @Query("select * from brastlewark where id = :idGnomo")
    suspend fun getGnomo(idGnomo : Int): BrastlewarkEntity?

    @Query("select * from brastlewark order by id desc")
    suspend fun getGnomos(): List<BrastlewarkEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGnomo(gnomoEntity: BrastlewarkEntity)
}