package com.mobile.umentoring.repository

import com.mobile.umentoring.model.ResponseUser
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

}