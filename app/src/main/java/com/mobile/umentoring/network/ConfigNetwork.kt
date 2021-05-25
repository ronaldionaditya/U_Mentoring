package com.mobile.umentoring.network

import com.mobile.umentoring.cons.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ConfigNetwork {

    companion object {

        //Todo initialisasi retrofit
        fun getRetrofit(): ConfigApi {

            //interceptor untuk mengetahui error kalau komunikasi server
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val builder = OkHttpClient.Builder()
                .addInterceptor(interceptor)

            val client = builder.build()
            var constants: Constants? = null
            constants = Constants()

            val retrofit = Retrofit.Builder()
                .baseUrl(constants?.BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigApi::class.java)

            return service
        }

    }

}