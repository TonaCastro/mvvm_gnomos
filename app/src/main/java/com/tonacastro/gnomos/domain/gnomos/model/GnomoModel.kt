package com.tonacastro.gnomos.domain.gnomos.model

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-18
 * @updated on
 * @modified by
 */
data class GnomoModel  (
    val id : Int,
    val name : String,
    val imageUrl : String,
    val age : String,
    val weight : String,
    val height : String,
    val hairColor : String,
    val professions : List<String>,
    val friends : List<String>
)