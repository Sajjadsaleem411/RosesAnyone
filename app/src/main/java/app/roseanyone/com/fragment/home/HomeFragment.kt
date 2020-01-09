package app.roseanyone.com.fragment.home

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import android.widget.EditText
import app.roseanyone.com.R
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.dialog_city.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment(), View.OnClickListener {
    var city=""
    lateinit var etSearch:EditText
    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setUI(view)

        return view
    }

    private fun setUI(view: View) {
        var offerAdpater = offerAdpater(activity!!, demoData())
        val verticalLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        view.rvHomeOffers.layoutManager = verticalLayoutManager
        view.rvHomeOffers.adapter = offerAdpater
        etSearch=view.etHomeSearch

        var  flowerAdpater= FlowerAdpater(activity!!, demoData2())
        val verticalLayoutManager1 = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        view.rvHomeFlower.layoutManager = verticalLayoutManager1
        view.rvHomeFlower.adapter = flowerAdpater

        view.ivList.setOnClickListener {
            val location = IntArray(2)
            view.ivList.getLocationOnScreen(location)
            openCityDialog(location)
        }

    }
    private fun setHintEditText(){
        etSearch.hint = resources.getString(R.string.searchIn)+" "+city
    }
    override fun onClick(view: View) {
      //  val id = view.id

    }
    private fun demoData(): List<Int> {
        var data: List<Int>
        data = ArrayList()
        data.add(R.drawable.slider1)
        data.add(R.drawable.slider2)
        data.add(R.drawable.slider1)
        data.add(R.drawable.slider2)
        return data
    }
    private fun demoData2(): List<Flower> {
        var data: List<Flower>
        data = ArrayList<Flower>()
        data.add(Flower(0,R.drawable.corporate,13.0,"Corporate","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
        data.add(Flower(0,R.drawable.individuals,13.0,"Individuals","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
        return data
    }
    private fun demoData1(): List<Int> {
        var data: List<Int>
        data = ArrayList()
        data.add(R.drawable.corporate)
        data.add(R.drawable.individuals)
        data.add(R.drawable.slider1)
        data.add(R.drawable.slider2)
        return data
    }

    fun openCityDialog(location: IntArray) {

        var dialog = Dialog(context) // Context, this, etc.
        dialog.setContentView(R.layout.dialog_city)
        //dialog.setTitle(msg);

        dialog.tvCity1.setOnClickListener {
            city=dialog.tvCity1.text.toString()
            setHintEditText()
            dialog.dismiss()
        }
        dialog.tvCity2.setOnClickListener {
            city=dialog.tvCity2.text.toString()
            setHintEditText()
            dialog.dismiss()
        }
        dialog.tvCity3.setOnClickListener {
            city=dialog.tvCity3.text.toString()
            setHintEditText()
            dialog.dismiss()
        }
        dialog.tvCity4.setOnClickListener {
            city=dialog.tvCity4.text.toString()
            setHintEditText()
            dialog.dismiss()
        }
        dialog.getWindow()!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        val wmlp = dialog.getWindow()!!.getAttributes()
        val window = dialog.getWindow()

        window!!.setGravity(Gravity.TOP)

        wmlp.x = location[0]   //x position
        wmlp.y = location[1]   //y position

        Log.d("Location", "x=" + location[0] + ",Y=" + location[1])

        dialog.setCancelable(true)
        dialog.show()
    //    setUI(dialog)
    }

}