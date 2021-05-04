package com.mobile.umentoring.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Leaderboard
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        val url_maps = HashMap<String, String>()
//        url_maps["Hannibal"] = "http://mentoring.barajacoding.or.id/slider/2.jpg"
//        url_maps["Big Bang Theory"] = "http://mentoring.barajacoding.or.id/slider/3.jpg"
//        url_maps["House of Cards"] = "http://mentoring.barajacoding.or.id/slider/4.jpg"
//        url_maps["Game of Thrones"] = "http://mentoring.barajacoding.or.id/slider/5.jpg"

        val file_maps = HashMap<String, Int>()
        file_maps["Hannibal"] = R.drawable.slider_dua
        file_maps["Big Bang Theory"] = R.drawable.slider_tiga
        file_maps["House of Cards"] = R.drawable.slider_empat
        file_maps["Game of Thrones"] = R.drawable.slider_lima

        for (name in file_maps.keys) {
            val textSliderView = TextSliderView(context)
            // initialize a SliderLayout
            textSliderView
                .description(name)
                .image(file_maps[name]!!)
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .setOnSliderClickListener(this)

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                .putString("extra", name)
            slider.addSlider(textSliderView)
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion)
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        slider.setCustomAnimation(DescriptionAnimation())
        slider.setDuration(5000)
        slider.addOnPageChangeListener(this)


    }

    override fun onSliderClick(slider: BaseSliderView?) {
        Toast.makeText(context, slider?.bundle?.get("extra").toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

}