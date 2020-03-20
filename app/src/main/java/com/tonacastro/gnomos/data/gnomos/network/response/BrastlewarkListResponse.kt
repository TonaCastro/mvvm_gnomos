package com.tonacastro.gnomos.data.gnomos.network.response

import com.google.gson.annotations.SerializedName

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
data class BrastlewarkListResponse (
    @SerializedName("Brastlewark") val brastlewark : List<Brastlewark>)
