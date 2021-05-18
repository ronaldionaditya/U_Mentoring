package com.mobile.umentoring.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.PortofolioAdapter
import com.mobile.umentoring.adapter.recyclerView.ProgramAdapter
import com.mobile.umentoring.adapter.recyclerView.TestimoniAdapter
import com.mobile.umentoring.model.*
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), BaseSliderView.OnSliderClickListener,
    ViewPagerEx.OnPageChangeListener {

    lateinit var view: ViewModel

    private var listProgram: RecyclerView? = null
//    private var listPortofolio: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Todo deklarasi viewmodel
        view = ViewModelProviders.of(this).get(ViewModel::class.java)

        attachObserveProg()
        attachObservePort()
        attachObserveTest()

        //Todo panggil api
        view.panggilApiProgram()
        view.panggilApiPort()
        view.panggilApiTest()


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

    //Todo observe dan pesan dari RecyclerView
    //Program
    private fun attachObserveProg() {
        view.successProg().observe(viewLifecycleOwner, Observer { showSuccessProg(it) })
        view.errorProg().observe(viewLifecycleOwner, Observer { showErrorProg(it) })
    }

    private fun showErrorProg(it: Throwable?) {
        Toast.makeText(context, "Salah", Toast.LENGTH_LONG).show()
    }
    private fun showSuccessProg(data: ResponseProgram?) {
        Toast.makeText(context, "Success Prog", Toast.LENGTH_SHORT).show()
        var adapter = ProgramAdapter(data?.data)
        rvProgram.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvProgram.adapter = adapter
        showData(data?.data)
    }
    private fun showData(data: List<DataItem?>?) {
        listProgram?.adapter = ProgramAdapter(data)
    }


    //Portofolio
    private fun attachObservePort(){
        view.successPort().observe(viewLifecycleOwner, Observer { showSuccessPort(it) })
        view.errorPort().observe(viewLifecycleOwner, Observer { showErrorPort(it) })
    }
    private fun showErrorPort(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
        Log.e("Error Port",it?.localizedMessage?:"")
    }
    private fun showSuccessPort(data: ResponsePortofolio?){
        Toast.makeText(context, "Success Port", Toast.LENGTH_SHORT).show()

        var dataa = data?.data
        for (x:Int in dataa?.indices?:0..1 ){
            var item = dataa?.get(x)?.participant
            Log.e("data","$item")

            var adapter = PortofolioAdapter(dataa)
            rvPortofolio.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            rvPortofolio.adapter = adapter
        }
//        showDataPort(dataa?.get(0)?.participant)
    }
//    private fun showDataPort(data: List<Participant?>?) {
//        listPortofolio?.adapter = PortofolioAdapter(data)
//    }


    //Testimoni
    private fun attachObserveTest(){
        view.successTest().observe(viewLifecycleOwner, Observer { showSuccessTest(it) })
        view.errorTest().observe(viewLifecycleOwner, Observer { showErrorTest(it) })
    }
    private fun showSuccessTest(data: ResponseTestimoni?){
        Toast.makeText(context, "Success Test", Toast.LENGTH_SHORT).show()

        var dataA = data?.data
        for (x:Int in dataA?.indices?:0..1){
            var item = dataA?.get(x)?.user
            Log.e("dataA", "$item")

            var adapter = TestimoniAdapter(dataA)
            rvTestimoni.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvTestimoni.adapter = adapter
        }


    }
    private fun showErrorTest(it: Throwable?){
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
        Log.e("Error Test" , it?.localizedMessage?:"")
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