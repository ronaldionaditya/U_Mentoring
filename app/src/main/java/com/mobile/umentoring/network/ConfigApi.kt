package com.mobile.umentoring.network

import com.mobile.umentoring.model.ResponseUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface ConfigApi {

    @GET("login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Observable<ResponseUser>

}