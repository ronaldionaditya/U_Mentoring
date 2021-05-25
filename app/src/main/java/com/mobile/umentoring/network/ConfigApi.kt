package com.mobile.umentoring.network

import com.mobile.umentoring.model.*
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface ConfigApi {

    @GET("login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Observable<ResponseUser>

    //Todo mengambil api program dari repo
    @GET("getProgram")
    fun getApiProgram(): Flowable<ResponseProgram>

    @GET("getPortofolio")
    fun getApiPortofolio(): Flowable<ResponsePortofolio>

    @GET("getTestimoni")
    fun getApiTestimoni(): Flowable<ResponseTestimoni>

    @GET("profile")
    fun getApiProfile(
        @Query("idUser") user: String
    ): Flowable<ResponseProfile>

    @GET("participant/getProgramUser")
    fun getApiProgramProfile(
        @Query("participant_id") participant: String
    ): Flowable<ResponseProgramProfile>

    @GET("participant/getPortofolio")
    fun getApiPortofolioProfile(
        @Query("participant_id") participantPort: String
    ): Flowable<ResponsePortofolioProfile>

    @GET("participant/getTestimoni")
    fun getApiTestimoniProfile(
        @Query("user_id") userTest: String
    ): Flowable<ResponseTestimoniProfile>

}