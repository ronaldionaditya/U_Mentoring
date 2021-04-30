package com.mobile.umentoring.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mobile.umentoring.R
import kotlinx.android.synthetic.main.fragment_leaderboard.*

@Suppress("UNREACHABLE_CODE")
class LeaderboardFragment : Fragment() {

    val kelas = arrayOf("All Class","Flutter", "Kotlin", "UiDesign", "Web", "English", "Kotlin II", "Flutter II")
    val batch = arrayOf("All Batch","1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_dropdown_item_1line, kelas) }
        val arrayAdapters =
            context?.let { ArrayAdapter(it, android.R.layout.simple_dropdown_item_1line, batch) }
        spOption1.adapter = arrayAdapter
        spOption2.adapter = arrayAdapters
        spOption1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(context, "You selected "+kelas[position], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spOption2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(context, "You selected "+batch[position], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
}