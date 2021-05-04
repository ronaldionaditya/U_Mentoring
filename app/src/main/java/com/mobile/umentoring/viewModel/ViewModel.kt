package com.mobile.umentoring.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.umentoring.model.ResponseUser
import com.mobile.umentoring.repository.Repository

class ViewModel:ViewModel() {

    // todo 2 inisiaslisasi repository
    val repository = Repository()

    //Todo membuat variabel agar bisa ditampung view
    var emailKosong = MutableLiveData<Boolean>()
    var passwordKosong = MutableLiveData<Boolean>()
    var errorLogin = MutableLiveData<Throwable>()
    var responLogin = MutableLiveData<ResponseUser>()


    fun login(
        email: String,
        password: String
    ){

        if (email.isEmpty()) {
            emailKosong.value = true

        } else if (password.isEmpty()) {
            passwordKosong.value = true

        } else {
            repository.login(email, password, {
                responLogin.value = it

            }, {
                errorLogin.value = it

            })
        }

    }

    fun emailIsEmpty():LiveData<Boolean>{
        return emailKosong
    }

    fun passwordIsEmpty():LiveData<Boolean>{
        return passwordKosong
    }

    fun loginError():LiveData<Throwable>{
        return errorLogin
    }

    fun loginResponse():LiveData<ResponseUser>{
        return responLogin
    }

}