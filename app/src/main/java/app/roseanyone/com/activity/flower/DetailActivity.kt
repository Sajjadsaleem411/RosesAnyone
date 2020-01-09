package app.roseanyone.com.activity.flower

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import app.roseanyone.com.R
import app.roseanyone.com.activity.MainActivity
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUI()
    }

    fun setUI() {
        val flower = intent.extras.get("flower") as Flower
     /*   var category: String = intent.extras!!.getString("category")
        if (!category.contains(resources.getString(R.string.flowers), ignoreCase = true)) {
            category += " "+resources.getString(R.string.flowers)
        }*/

        tvFlowerTitle.text = intent.extras!!.getString("category")
        toolbarImage.setImageResource(flower.image!!)
        tvDetailDesc.text = flower.desc!!
        tvItemCartPrice.text = "" + flower.price!!
        btnDetailAdd.setOnClickListener {
            val list = MainActivity.cartList
            flower.qty = tvDetailQty.text.toString().toInt()
            list.add(flower)
            MainActivity.cartList = list
            Toast.makeText(this, "Added flower in cart", Toast.LENGTH_SHORT).show()
            /* Snackbar.make(view, "Added flower in cart", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).setActionTextColor(context.getResources().getColor(R.color.white)).show();
          */      setToolbarCart()
            finish()
        }
        ivDetailBack.setOnClickListener {
            finish()
        }
        tvDetailPlus?.setOnClickListener {
            var qty = tvDetailQty!!.text.toString().toInt()
            tvDetailQty!!.text = "" + (++qty)

        }
        tvDetailMinus?.setOnClickListener {

            var qty = tvDetailQty!!.text.toString().toInt()
            if (qty > 1)
                tvDetailQty!!.text = "" + (--qty)
        }
        flToolbarCart.setOnClickListener { MainActivity.newInstance(this,1) }
        setToolbarCart()
    }

    fun setToolbarCart() {
        tvToolbarCart.text = """${MainActivity.cartList.size}"""
    }
}
