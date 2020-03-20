package com.tonacastro.gnomos.domain.gnomos.manager

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-20
 * @updated on
 * @modified by
 */
class GnomoClasificationManager {

    fun guessGender(heigth: Double) : String{
        var gender = ""
        if (heigth > 90.0) {
            gender = "Male"
        } else {
            gender = "Female"
        }
        return gender
    }
}