package app.roseanyone.com.activity.flower

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import app.roseanyone.com.R
import app.roseanyone.com.activity.MainActivity
import app.roseanyone.com.fragment.home.FlowerAdpater
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.activity_flower.*

class FlowerActivity : AppCompatActivity() {
    companion object {
        fun newInstance(activity: Activity) {
            var intent = Intent(activity, FlowerActivity::class.java)
             //  intent.putExtra("Splash", false)
            activity.startActivity(intent)

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower)
        setUI()
    }

    private fun setUI() {
        var flowerAdpater = FlowerActicityAdpater(this, demoData())
        val verticalLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvFlower.layoutManager = verticalLayoutManager1
        rvFlower.adapter = flowerAdpater

        ivFlowerBack.setOnClickListener {
            MainActivity.newInstance(this)
          //  finish()
        }
    }

    private fun demoData1(): List<Int> {
        var data: List<Int>
        data = ArrayList()
        data.add(R.drawable.corporate)
        data.add(R.drawable.individuals)
        data.add(R.drawable.slider1)
        data.add(R.drawable.slider2)
        data.add(R.drawable.corporate)
        data.add(R.drawable.individuals)
        data.add(R.drawable.slider1)
        data.add(R.drawable.slider2)
        return data
    }
    private fun demoData(): List<Flower> {
        var data: List<Flower>
        data = ArrayList<Flower>()
        data.add(Flower(0,R.drawable.demo_4_3,13.0,"Conference","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
        data.add(Flower(0,R.drawable.demo_1,13.0,"Promotions","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
        data.add(Flower(0,R.drawable.demo_2,13.0,"Employees Motivation","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
        data.add(Flower(0,R.drawable.demo_5,13.0,"Wedding Planner","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
        data.add(Flower(0,R.drawable.demo_3,13.0,"Meeting Greetings","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1))
              data.add(Flower(0,R.drawable.demo_6_1,13.0,"Retirements","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
            1))
        data.add(Flower(0,R.drawable.demo_1_3,13.0,"Delegates","A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
            1))

        return data
    }
}
