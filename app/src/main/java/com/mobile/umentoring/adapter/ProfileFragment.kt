package com.mobile.umentoring.adapter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.mobile.umentoring.view.MainActivity
import com.mobile.umentoring.R
import com.mobile.umentoring.model.ResponseProfile
import com.mobile.umentoring.pref.SessionManager
import com.mobile.umentoring.repository.Repository
import com.mobile.umentoring.viewModel.ViewModel

import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    //    lateinit var sharedpref : PreferencesHelper
    var pref: SessionManager? = null
    var id: Int? = 0
    lateinit var view: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //initialisasi untuk profile
        view = ViewModelProvider(this)[ViewModel::class.java]

        pref = SessionManager(context)

        if (pref?.login ?: true) {
            id = pref?.id
        }

        attachObserveProfile()

        //panggil api dari viewmodel
        view.panggilApiProfile(id.toString())
        ivLogout.setOnClickListener {
            Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show()
            pref?.logout()
            moveIntent()
        }

        ivSetting.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_profileFragment2_to_profileUpdateFragment)
        }

    }

    private fun moveIntent() {
        startActivity(Intent(requireContext(), MainActivity::class.java))

    }

    private fun attachObserveProfile() {
        view.successProfile().observe(viewLifecycleOwner, Observer { showSuccessProfile(it) })
        view.errorProfile().observe(viewLifecycleOwner, Observer { showErrorProfile(it) })
    }

    private fun showErrorProfile(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessProfile(data: ResponseProfile) {
        Toast.makeText(context, "Success Profile", Toast.LENGTH_SHORT).show()
        tvNamaProfile.text=data.data?.name
        tvLevelProfile.text=data.data?.level
        Glide.with(this)
            .load(data?.data?.image)
            .into(profile_image)
    }

}