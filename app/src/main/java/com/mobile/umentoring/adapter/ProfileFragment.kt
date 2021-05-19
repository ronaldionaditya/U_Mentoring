package com.mobile.umentoring.adapter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.mobile.umentoring.MainActivity
import com.mobile.umentoring.R
import com.mobile.umentoring.pref.PreferencesHelper
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var sharedpref : PreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedpref = PreferencesHelper(requireContext())
        ivLogout.setOnClickListener {
            Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show()
            sharedpref.logout()
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(requireContext(), MainActivity::class.java))

    }


}