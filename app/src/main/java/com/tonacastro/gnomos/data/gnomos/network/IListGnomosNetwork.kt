package com.tonacastro.gnomos.data.gnomos.network

import com.tonacastro.gnomos.data.gnomos.network.response.BrastlewarkListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
interface IListGnomosNetwork {
    @GET("data.json")
    suspend fun getGnomos(): BrastlewarkListResponse
}