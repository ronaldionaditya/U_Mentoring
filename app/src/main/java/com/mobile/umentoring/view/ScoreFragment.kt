package com.mobile.umentoring.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Profile.MyScoreAdapter
import com.mobile.umentoring.adapter.recyclerView.Profile.TestimoniProfileAdapter
import com.mobile.umentoring.model.ResponseMyScore
import com.mobile.umentoring.model.ResponseTotalScore
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_score.*

class ScoreFragment : Fragment() {

    lateinit var view: ViewModel
    var participantTotal: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view = ViewModelProvider(this)[ViewModel::class.java]
        attachObserveScore()

        view.panggilApiTotalScore("9")
//        view.panggilApiMyScore("9")

        ivBackScore.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_scoreFragment_to_profileFragment2)
        }
    }

    private fun attachObserveScore(){
        view.successTotalScore()
            .observe(viewLifecycleOwner, Observer { showSuccessTotalScore(it) })
        view.errorTotalScore()
            .observe(viewLifecycleOwner, Observer { showErrorTotalScore(it) })


//        view.successMyScore()
//            .observe(viewLifecycleOwner, Observer { showSuccessMyScore(it) })
//        view.errorMyScore()
//            .observe(viewLifecycleOwner, Observer { showErrorMyScore(it) })
    }

    private fun showErrorTotalScore(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessTotalScore(it: ResponseTotalScore?) {
        Toast.makeText(context, "Success My Score", Toast.LENGTH_SHORT).show()

        tvTotalMyScore.text = it?.data?.totalScore.toString()
    }


//
//    private fun showErrorMyScore(it: Throwable?) {
//        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
//    }
//
//    private fun showSuccessMyScore(it: ResponseMyScore?) {
//        Toast.makeText(context, "Success My Score", Toast.LENGTH_SHORT).show()
//
//        var adapter = MyScoreAdapter(it?.data)
//        rvTestimoniProfile.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        rvTestimoniProfile.adapter = adapter
//    }


}