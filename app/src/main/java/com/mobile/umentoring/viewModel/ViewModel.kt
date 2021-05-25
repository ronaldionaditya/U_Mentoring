package com.mobile.umentoring.viewModel


import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.umentoring.model.*
import com.mobile.umentoring.repository.Repository

class ViewModel : ViewModel() {

    // Todo 2 inisiaslisasi repository
    val repository = Repository()

    // Todo membuat variabel agar bisa ditampung view
    var emailKosong = MutableLiveData<Boolean>()
    var passwordKosong = MutableLiveData<Boolean>()
    var errorLogin = MutableLiveData<Throwable>()
    var responLogin = MutableLiveData<ResponseUser>()

    // Todo RecyclerView
    var repo = Repository()

    //Home
    var successProg = MutableLiveData<ResponseProgram>()
    var errorProg = MutableLiveData<Throwable>()
    var successPort = MutableLiveData<ResponsePortofolio>()
    var errorPort = MutableLiveData<Throwable>()
    var successTest = MutableLiveData<ResponseTestimoni>()
    var errorTest = MutableLiveData<Throwable>()

    //Profile
    var successProfile = MutableLiveData<ResponseProfile>()
    var errorProfile = MutableLiveData<Throwable>()

    var succeessProgramProfile = MutableLiveData<ResponseProgramProfile>()
    var errorProgramProfile = MutableLiveData<Throwable>()

    var succeessPortofolioProfile = MutableLiveData<ResponsePortofolioProfile>()
    var errorPortofolioProfile = MutableLiveData<Throwable>()

    var succeessTestimoniProfile = MutableLiveData<ResponseTestimoniProfile>()
    var errorTestimoniProfile = MutableLiveData<Throwable>()



    //Todo ProgressBar
    var progressBar = MutableLiveData<Boolean>()

    fun login(
        email: String,
        password: String
    ) {
        progressBar.value = true
        if (email.isEmpty()) {
            emailKosong.value = true
            progressBar.value = false

        } else if (password.isEmpty()) {
            passwordKosong.value = true
            progressBar.value = false

        } else {
            repository.login(email, password, {
                responLogin.value = it
                progressBar.value = false
            }, {
                errorLogin.value = it
                progressBar.value = false
            })
        }

    }

    fun emailIsEmpty(): LiveData<Boolean> {
        return emailKosong
    }

    fun passwordIsEmpty(): LiveData<Boolean> {
        return passwordKosong
    }

    fun loginError(): LiveData<Throwable> {
        return errorLogin
    }

    fun loginResponse(): LiveData<ResponseUser> {
        return responLogin
    }

    //ProgressBar LiveData untuk dibawa ke Fragment
    fun progressBarLive(): LiveData<Boolean>{
        return progressBar
    }


    //Todo panggil repo api RecyclerView
    //Program
    fun panggilApiProgram() {
        progressBar.value = true
        repo.getApiProgram({
            successProg.value = it
            progressBar.value = false
        }, {
            errorProg.value = it
            progressBar.value = false
        })
    }

    fun successProg(): LiveData<ResponseProgram> {
        return successProg
    }

    fun errorProg(): LiveData<Throwable> {
        return errorProg
    }

    //Portofolio
    fun panggilApiPort() {
        progressBar.value = true
        repo.getApiPortofolio({
            successPort.value = it
            progressBar.value = false
        }, {
            errorPort.value = it

        })
    }

    fun successPort(): LiveData<ResponsePortofolio> {
        return successPort
    }

    fun errorPort(): LiveData<Throwable> {
        return errorPort
    }


    //Testimoni
    fun panggilApiTest() {
        progressBar.value = true
        repo.getApiTestimoni({
            successTest.value = it
            progressBar.value = false
        }, {
            errorTest.value = it
            progressBar.value = false
        })
    }

    fun successTest(): LiveData<ResponseTestimoni> {
        return successTest
    }

    fun errorTest(): LiveData<Throwable> {
        return errorTest
    }


    //Profile User
    fun panggilApiProfile(user: String) {
        progressBar.value = true
        repo.getApiProfile(user, {
            successProfile.value = it
            progressBar.value = false
        }, {
            errorProfile.value = it
            progressBar.value = false
        })
    }

    fun successProfile(): LiveData<ResponseProfile> {
        return successProfile
    }

    fun errorProfile(): LiveData<Throwable> {
        return errorProfile
    }

    //Profile Program
    fun panggilApiProgramProfile(participant:String){
        repo.getApiProgramProfile(participant,{
            succeessProgramProfile.value = it
        },{
            errorProgramProfile.value = it
        })
    }

    fun succeessProgramProfile(): LiveData<ResponseProgramProfile>{
        return succeessProgramProfile
    }

    fun errorProgramProfile(): LiveData<Throwable>{
        return errorProgramProfile
    }

    //Profile Portofolio
    fun panggilApiPortofolioProfile(participantPort:String){
        repo.getApiPortofolioProfile(participantPort,{
            succeessPortofolioProfile.value = it
        },{
            errorPortofolioProfile.value = it
        })
    }

    fun succeessPortofolioProfile(): LiveData<ResponsePortofolioProfile>{
        return succeessPortofolioProfile
    }

    fun errorPortofolioProfile(): LiveData<Throwable>{
        return errorPortofolioProfile
    }

    //Profile Testimoni
    fun panggilApiTestimoniProfile(userTest:String){
        repo.getApiTestimoniProfile(userTest,{
            succeessTestimoniProfile.value = it
        },{
            errorTestimoniProfile.value = it
        })
    }

    fun successTestimoniProfile(): LiveData<ResponseTestimoniProfile>{
        return succeessTestimoniProfile
    }

    fun errorTestimoniProfile(): LiveData<Throwable>{
        return errorTestimoniProfile
    }



}