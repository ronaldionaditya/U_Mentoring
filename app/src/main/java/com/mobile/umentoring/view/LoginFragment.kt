package com.mobile.umentoring.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.HomeFragment
import com.mobile.umentoring.cons.Constants
import com.mobile.umentoring.model.ResponseUser
import com.mobile.umentoring.pref.PreferencesHelper
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    //Todo deklarasi ViewModel
    lateinit var viewModel: com.mobile.umentoring.viewModel.ViewModel

//    //Todo login session SharedPreferences
    lateinit var sharedpref : PreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sharedpref = PreferencesHelper(requireContext())

        viewModel = ViewModelProviders.of(this).get(com.mobile.umentoring.viewModel.ViewModel::class.java)
        pengamatan()
        btnSignIn.setOnClickListener {

            if(etEmail.text?.isNotEmpty()!! && etPassword.text?.isNotEmpty()!!){
                var constants: Constants? = null
                constants = Constants()
                sharedpref.put(constants.PREF_USERNAME, etEmail.text.toString())
                sharedpref.put(constants.PREF_PASSWORD, etPassword.text.toString())
                sharedpref.put(constants.PREF_IS_LOGIN, true)
                Toast.makeText(context, "Berhasil masuk", Toast.LENGTH_SHORT).show()

                Navigation.findNavController(requireView())
                    .navigate(R.id.action_loginFragment_to_menuActivity)
            }

            //todo 1 ambil view
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()

            viewModel.login(email, password)
        }

        tvForgotPass.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_loginFragment_to_forgotFragment)
        }

    }

    override fun onStart() {
        super.onStart()
        var constants: Constants? = null
        constants = Constants()
        if (sharedpref.getBoolean(constants.PREF_IS_LOGIN) == true){
            Navigation.findNavController(requireView())
                .navigate(R.id.action_loginFragment_to_menuActivity)
        }
    }






    private fun pengamatan() {
        viewModel.loginResponse().observe(viewLifecycleOwner, Observer { loginResponse(it) })
        viewModel.loginError().observe(viewLifecycleOwner, Observer { loginError(it) })
        viewModel.emailIsEmpty().observe(viewLifecycleOwner, Observer { emailIsEmpty(it) })
        viewModel.passwordIsEmpty().observe(viewLifecycleOwner, Observer { passwordIsEmpty(it) })
    }


    private fun passwordIsEmpty(it: Boolean?) {
        etPassword.requestFocus()
        etPassword.error = "Password kosong"
    }

    private fun emailIsEmpty(it: Boolean?) {
        etEmail.requestFocus()
        etEmail.error = "Email kosong"
    }

    private fun loginResponse(it: ResponseUser){
        if (it.status==true){
            Toast.makeText(context,it.message, Toast.LENGTH_SHORT).show()

            Navigation.findNavController(requireView())
                .navigate(R.id.action_loginFragment_to_menuActivity)

        }else{
            Toast.makeText(context,it.message, Toast.LENGTH_SHORT).show()

        }
    }

    private fun loginError(it: Throwable){
        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
    }




}