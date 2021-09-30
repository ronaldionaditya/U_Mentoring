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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mobile.umentoring.view.MainActivity
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Profile.PortofolioProfileAdapter
import com.mobile.umentoring.adapter.recyclerView.Profile.ProgramProfileAdapter
import com.mobile.umentoring.adapter.recyclerView.Profile.TestimoniProfileAdapter
import com.mobile.umentoring.model.*
import com.mobile.umentoring.pref.SessionManager
import com.mobile.umentoring.viewModel.ViewModel

import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    //    lateinit var sharedpref : PreferencesHelper
    var pref: SessionManager? = null
    var id: Int? = 0
    var participant_id: Int? = 0
    var user_id: Int? = 0
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

        //panggil id api dari viewmodel
        Toast.makeText(context, "Id :" + participant_id, Toast.LENGTH_SHORT).show()
        view.panggilApiProfile(id.toString())
        view.panggilApiProgramProfile(participant_id.toString())
//        view.panggilApiPortofolioProfile(participant_id.toString())
        //TODO masih menggunakan id manual tidak dari api
        //nanti tinggal diganti ke api
        view.panggilApiPortofolioProfile("1560")
        view.panggilApiTestimoniProfile("923")

        ivLogout.setOnClickListener {
//            Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show()
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
        view.progressBarLive().observe(viewLifecycleOwner, Observer { loading(it) })

        view.successProfile().observe(viewLifecycleOwner, Observer { showSuccessProfile(it) })
        view.errorProfile().observe(viewLifecycleOwner, Observer { showErrorProfile(it) })

        view.succeessProgramProfile()
            .observe(viewLifecycleOwner, Observer { showSuccessProgramProfile(it) })
        view.errorProgramProfile()
            .observe(viewLifecycleOwner, Observer { showErrorProgramProfile(it) })

        view.succeessPortofolioProfile()
            .observe(viewLifecycleOwner, Observer { showSuccessPortofolioProfile(it) })
        view.errorPortofolioProfile()
            .observe(viewLifecycleOwner, Observer { showErrorPortofolioProfile(it) })

        view.successTestimoniProfile()
            .observe(viewLifecycleOwner, Observer { showSuccessTestimoniProfile(it) })
        view.errorTestimoniProfile()
            .observe(viewLifecycleOwner, Observer { showErrorTestimoniProfile(it) })
    }


    //User
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

    //Program/Class
    private fun showErrorProgramProfile(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessProgramProfile(it: ResponseProgramProfile?) {
//        Toast.makeText(context, "Success Profile", Toast.LENGTH_SHORT).show()

        var logss = it?.data
        Log.e("dataaaaaaa", "$logss")

        var adapter = ProgramProfileAdapter(it?.data, object : ProgramProfileAdapter.klik {
            override fun a(data: DataItemProgramProfile?) {
                val bundle = Bundle()
                bundle.putParcelable("", data)
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_profileFragment2_to_scoreFragment,bundle)

            //                Toast.makeText(context, data?.program.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        rvClassProfile.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvClassProfile.adapter = adapter
    }

    //Portofolio
    private fun showErrorPortofolioProfile(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessPortofolioProfile(it: ResponsePortofolioProfile?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
        var logss = it?.data
        Log.e("dataaaa portofolio", "$logss")

        var adapter = PortofolioProfileAdapter(it?.data)
        rvPortofolioProfile.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPortofolioProfile.adapter = adapter
    }

    //Testimoni
    private fun showErrorTestimoniProfile(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessTestimoniProfile(it: ResponseTestimoniProfile?) {
        Toast.makeText(context, "Success Testimoni", Toast.LENGTH_SHORT).show()
        var logs = it?.data
        Log.e("dataa testimoni", "$logs")

        var adapter = TestimoniProfileAdapter(it?.data)
        rvTestimoniProfile.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvTestimoniProfile.adapter = adapter
    }

}