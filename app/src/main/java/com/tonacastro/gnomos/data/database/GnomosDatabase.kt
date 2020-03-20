package com.tonacastro.gnomos.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tonacastro.gnomos.data.gnomos.dao.MasterGnomosDAO
import com.tonacastro.gnomos.data.gnomos.model.BrastlewarkEntity

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
@Database(entities = arrayOf(BrastlewarkEntity::class), version = 1,exportSchema = false)
abstract class GnomosDatabase : RoomDatabase() {

    abstract val gnomosDao : MasterGnomosDAO

    companion object {

        @Volatile
        private var INSTANCE: GnomosDatabase? = null

        fun getDatabase(context: Context): GnomosDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GnomosDatabase::class.java,
                        "gnomos_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}