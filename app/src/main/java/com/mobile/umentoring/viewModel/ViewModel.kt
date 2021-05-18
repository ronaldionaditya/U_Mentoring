package com.mobile.umentoring.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.umentoring.model.*
import com.mobile.umentoring.repository.Repository

class ViewModel:ViewModel() {

    // Todo 2 inisiaslisasi repository
    val repository = Repository()

    // Todo membuat variabel agar bisa ditampung view
    var emailKosong = MutableLiveData<Boolean>()
    var passwordKosong = MutableLiveData<Boolean>()
    var errorLogin = MutableLiveData<Throwable>()
    var responLogin = MutableLiveData<ResponseUser>()

    // Todo RecyclerView
    var repo = Repository()

    var successProg = MutableLiveData<ResponseProgram>()
    var errorProg = MutableLiveData<Throwable>()

    var successPort = MutableLiveData<ResponsePortofolio>()
    var errorPort = MutableLiveData<Throwable>()

    var successTest = MutableLiveData<ResponseTestimoni>()
    var errorTest = MutableLiveData<Throwable>()

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


    //Todo panggil repo api RecyclerView
    //Program
    fun panggilApiProgram(){
        repo.getApiProgram({
            successProg.value = it
        },{
            errorProg.value = it
        })
    }

    fun successProg(): LiveData<ResponseProgram> {
        return successProg
    }

    fun errorProg(): LiveData<Throwable> {
        return errorProg
    }

    //Portofolio
    fun panggilApiPort(){
        repo.getApiPortofolio({
            successPort.value= it
        },{
            errorPort.value= it
        })
    }
    fun successPort(): LiveData<ResponsePortofolio>{
        return successPort
    }
    fun errorPort(): LiveData<Throwable> {
        return errorPort
    }


    //Testimoni
    fun panggilApiTest(){
        repo.getApiTestimoni({
            successTest.value= it
        },{
            errorTest.value= it
        })
    }
    fun successTest(): LiveData<ResponseTestimoni>{
        return successTest
    }
    fun errorTest(): LiveData<Throwable> {
        return errorTest
    }

}