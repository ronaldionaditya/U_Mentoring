package com.mobile.umentoring.network

import com.mobile.umentoring.cons.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ConfigNetwork {

    companion object {
        fun getRetrofit(): ConfigApi {
            val builder = OkHttpClient.Builder()

            val client = builder.build()
            var constants: Constants?=null
            constants = Constants()

            val retrofit = Retrofit.Builder()
                .baseUrl(constants?.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigApi::class.java)

            return service
        }

    }

}