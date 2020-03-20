package com.tonacastro.gnomos.data.gnomos.network.response

import com.google.gson.annotations.SerializedName
import com.tonacastro.gnomos.data.gnomos.model.BrastlewarkEntity

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
data class Brastlewark (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("thumbnail") val thumbnail : String,
    @SerializedName("age") val age : Int,
    @SerializedName("weight") val weight : Double,
    @SerializedName("height") val height : Double,
    @SerializedName("hair_color") val hairColor : String,
    @SerializedName("professions") val professions : List<String>?,
    @SerializedName("friends") val friends : List<String>?
)

fun Brastlewark.toEntityBrastlewark() = BrastlewarkEntity(id,
    name,
    thumbnail,
    age,
    weight,
    height,
    hairColor)