package com.mobile.umentoring.repository

import com.mobile.umentoring.model.*
import com.mobile.umentoring.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun login(
        email: String,
        password: String,
        responseHandler: (ResponseUser) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getApiProgram(
        responseSuccess: (ResponseProgram) -> Unit,
        responseError: (Throwable) -> Unit
    ) {

        ConfigNetwork.getRetrofit().getApiProgram().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseSuccess(response)
            }, { e ->
                responseError(e)
            })
    }

    fun getApiPortofolio(
        responseSuccess: (ResponsePortofolio) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().getApiPortofolio().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            }, {
                responseError(it)
            })
    }

    fun getApiTestimoni(
        responseSuccess: (ResponseTestimoni) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().getApiTestimoni().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            }, {
                responseError(it)
            })
    }

    fun getApiProfile(
        user : String,
        responseSuccess: (ResponseProfile) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().getApiProfile(user).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            }, {
                responseError(it)
            })
    }

}