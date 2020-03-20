package com.tonacastro.gnomos.data.gnomos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.tonacastro.gnomos.domain.gnomos.model.GnomoModel

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
@Entity(tableName = "brastlewark")
data class BrastlewarkEntity (
    @PrimaryKey
    val id : Int,
    val name : String,
    val thumbnail : String,
    val age : Int,
    val weight : Double,
    val height : Double,
    val hairColor : String
    //val professions : List<String>?,
    //val friends : List<String>?
)

fun BrastlewarkEntity.toDomainModel() = GnomoModel(id,
    name,
    thumbnail,
    age.toString(),
    weight.toString(),
    height.toString(),
    hairColor,
    arrayListOf(),
    arrayListOf())