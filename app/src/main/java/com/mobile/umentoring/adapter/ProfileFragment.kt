package com.mobile.umentoring.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.mobile.umentoring.view.MainActivity
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.ProgramProfileAdapter
import com.mobile.umentoring.model.DataItemProgramProfile
import com.mobile.umentoring.model.ResponseProfile
import com.mobile.umentoring.model.ResponseProgramProfile
import com.mobile.umentoring.pref.SessionManager
import com.mobile.umentoring.repository.Repository
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_home.*

import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    //    lateinit var sharedpref : PreferencesHelper
    var pref: SessionManager? = null
    var id: Int? = 0
    var participant_id: Int? = 0
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

        attachObserveProfile()

        pref = SessionManager(context)

        if (pref?.login ?: true) {
            id = pref?.id
            participant_id = pref?.participant_id
        }


        //panggil api dari viewmodel
        view.panggilApiProfile(id.toString())
        view.panggilApiProgramProfile(participant_id.toString())

        ivLogout.setOnClickListener {
            Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show()
            pref?.logout()
            moveIntent()
        }

        ivSetting.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_profileFragment2_to_profileUpdateFragment)
        }

//        btnEditTestimoniProfile.setOnClickListener {
//            Navigation.findNavController(it)
//                .navigate(R.id.action_profileFragment2_to_testimonialFragment)
//        }


    }

    private fun moveIntent() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    private fun loading(it: Boolean?) {
        if (it == true) {
            pbProfile.visibility = View.VISIBLE

        }
        if (it == false) {
            pbProfile.visibility = View.GONE
        }
    }

    private fun attachObserveProfile() {
        view.successProfile().observe(viewLifecycleOwner, Observer { showSuccessProfile(it) })
        view.errorProfile().observe(viewLifecycleOwner, Observer { showErrorProfile(it) })
        view.progressBarLive().observe(viewLifecycleOwner, Observer { loading(it) })

        view.succeessProgramProfile()
            .observe(viewLifecycleOwner, Observer { showSuccessProgramProfile(it) })
        view.errorProgramProfile()
            .observe(viewLifecycleOwner, Observer { showErrorProgramProfile(it) })
    }

    private fun showErrorProfile(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessProfile(data: ResponseProfile) {
//        Toast.makeText(context, "Success Profile", Toast.LENGTH_SHORT).show()


        tvNamaProfile.text = data.data?.name
        tvLevelProfile.text = data.data?.level
        Glide.with(this)
            .load(data?.data?.image)
            .into(profile_image)
    }


    private fun showErrorProgramProfile(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    //TODO YANG BELUM SIAP
    private fun showSuccessProgramProfile(it: ResponseProgramProfile?) {
        Toast.makeText(context, "Success Profile", Toast.LENGTH_SHORT).show()

        //TODO TANYA DA NANDO MODEL BERMASALAH
        var logss = it?.data
        Log.e("dataaaaaaa", "$logss")


        var adapter = ProgramProfileAdapter(it?.data)
        rvClassProfile.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvClassProfile.adapter = adapter

    }

}