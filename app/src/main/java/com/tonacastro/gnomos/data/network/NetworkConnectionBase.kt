package com.tonacastro.gnomos.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * @author tonatiuh
 * @version 1.0
 * @desc
 * @created 2020-03-17
 * @updated on
 * @modified by
 */
open class NetworkConnectionBase: INetworkConnection {

    lateinit var retrofit: Retrofit

    override fun onCreateConnection(url: String) {
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(makeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun makeOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(makeLoggingInterceptor())
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
            HttpLoggingInterceptor.Level.BODY
        return logging
    }

    interface  NetworkConnectionListener {
        fun OnSuccessConnection(response: IResponse)
        fun OnErrorConnection(error: String)
    }

}