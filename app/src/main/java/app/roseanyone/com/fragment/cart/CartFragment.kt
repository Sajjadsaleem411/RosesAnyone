package app.roseanyone.com.fragment.cart

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import app.roseanyone.com.R
import app.roseanyone.com.activity.AddressActivity
import app.roseanyone.com.activity.MainActivity
import app.roseanyone.com.fragment.ThankYouDialog
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlin.collections.ArrayList


class CartFragment : Fragment(), View.OnClickListener, CartListener {

    var cartAdpater: CartAdpater? = null
    var tvTotal: TextView? = null
    override fun deleteItem(position: Int) {
        MainActivity.cartList.removeAt(position)
        cartAdpater!!.notifyDataSetChanged()

        tvTotal!!.text = "${getTotal()}"
    }

    override fun increseQty(position: Int, qty: Int) {
        MainActivity.cartList.get(position).qty=qty
        cartAdpater!!.notifyDataSetChanged()

        tvTotal!!.text = "${getTotal()}"
    }

    companion object {
        fun newInstance(): CartFragment {
            val fragment = CartFragment()

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        setUI(view)

        return view
    }

    private fun setUI(view: View) {
        cartAdpater = CartAdpater(activity!!, MainActivity.cartList, this)
        val verticalLayoutManager1 = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        tvTotal=view.tvCartTotal
        view.rvCart.layoutManager = verticalLayoutManager1
        view.rvCart.adapter = cartAdpater
        view.llCartBottom.setOnClickListener {
            if (MainActivity.cartList.size > 0)
                startActivity(Intent(activity, AddressActivity::class.java))
            /* ThankYouDialog.newInstance(activity as MainActivity)
                 .show(activity!!.supportFragmentManager)*//*
            var home=activity as MainActivity
            home.openHomeFragment()*/
        }
        var total = 0.0
        for (flower in MainActivity.cartList) {
            total += flower.price!! *flower.qty!!
        }
        tvTotal!!.text = "${getTotal()}"



    }

    private fun getTotal(): Double {
        var total = 0.0
        for (flower in MainActivity.cartList) {
            total += flower.price!!*flower.qty!!
        }
        return total
    }

    override fun onClick(view: View) {
        //  val id = view.id

    }

    private fun demoData(): List<Flower> {
        var data: List<Flower>
        data = ArrayList()
        data.add(Flower(0, R.drawable.corporate, 13.0, "Conference", "dsjdkjs djks ljd", 1))
        data.add(Flower(0, R.drawable.individuals, 15.0, "Wedding", "dsjdkjs djks ljd", 1))
        data.add(Flower(0, R.drawable.slider1, 17.0, "Conference", "dsjdkjs djks ljd", 1))
        data.add(Flower(0, R.drawable.individuals, 10.0, "Conference", "dsjdkjs djks ljd", 1))
        data.add(Flower(0, R.drawable.corporate, 19.0, "Conference", "dsjdkjs djks ljd", 1))
        data.add(Flower(0, R.drawable.slider1, 9.0, "Conference", "dsjdkjs djks ljd", 1))

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

}