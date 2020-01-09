package app.roseanyone.com.activity.flower

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import app.roseanyone.com.R
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.activity_add_flower.*
import android.widget.AdapterView.OnItemClickListener
import app.roseanyone.com.activity.MainActivity
import java.io.Serializable


class AddFlowerActivity : AppCompatActivity() {
    companion object {
        var cartList = ArrayList<Flower>()

        fun newInstance(activity: Activity, category: String) {
            var intent = Intent(activity, AddFlowerActivity::class.java)

            intent.putExtra("category", category)
            activity.startActivity(intent)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_flower)
        setUI()
    }

    private fun setUI() {

        var category: String = intent.extras!!.getString("category")
        if (!category.contains(resources.getString(R.string.flowers), ignoreCase = true)) {
            category += " "+resources.getString(R.string.flowers)
        }

        tvFlowerTitle.text = category
        var flowerAdpater = AddFlowerAdapter(this, demoData())
        gvAddFlower.adapter = flowerAdpater
        /*  gvAddFlower.onItemClickListener = object : AdapterView.OnItemClickListener {
              override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                  startActivity(Intent(this@AddFlowerActivity,DetailActivity::class.java))

              }
          }*/
        flToolbarCart.setOnClickListener { MainActivity.newInstance(this, 1) }
        gvAddFlower.setOnItemClickListener { parent, v, position, id ->
            val intent1 = Intent(this@AddFlowerActivity, DetailActivity::class.java)
            intent1.putExtra("flower", demoData()[position] as Serializable)
            intent1.putExtra("category", tvFlowerTitle.text.toString())
            startActivity(intent1)
            // startActivity(Intent(this@AddFlowerActivity,DetailActivity::class.java))

        }
        ivAddFlowerBack.setOnClickListener {
            finish()
        }
        setToolbarCart()
    }

    fun setToolbarCart() {
        tvToolbarCart.text = """${MainActivity.cartList.size}"""
    }

    private fun demoData(): List<Flower> {
        var data: List<Flower>
        data = ArrayList<Flower>()
        data.add(
            Flower(
                0,
                R.drawable.demo_4,
                15.0,
                "Conference",
                resources.getString(R.string.conferenceDesc),
                1
            )
        )
        data.add(
            Flower(
                0,
                R.drawable.demo_4_1,
                13.0,
                "Conference",
                resources.getString(R.string.conferenceDesc),
                1
            )
        )
        data.add(
            Flower(
                0,
                R.drawable.demo_4_2,
                19.0,
                "Conference",
                resources.getString(R.string.conferenceDesc),
                1
            )
        )
        data.add(
            Flower(
                0,
                R.drawable.demo_4_3,
                11.0,
                "Conference",
                "A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1
            )
        )
        data.add(
            Flower(
                0,
                R.drawable.demo_4_4,
                14.0,
                "Conference",
                "A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1
            )
        )
        data.add(
            Flower(
                0,
                R.drawable.demo_5,
                19.0,
                "Conference",
                "A beautiful fresh flower for you. Enjoy the fragrance and new style from Roses Anyone - your personal flowers App.  This flower is especially designed for celebration purposes and can be gifted to your loved ones with a nice envelop having  message from you",
                1
            )
        )

        return data
    }

    override fun onResume() {
        super.onResume()
        setToolbarCart()
    }
}
