package com.mobile.umentoring.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mobile.umentoring.R
import kotlinx.android.synthetic.main.fragment_forgot.*
import kotlinx.android.synthetic.main.fragment_reset.*

class ResetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ivBackReset.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_resetFragment_to_forgotFragment)
        }
    }
}