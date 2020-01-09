package app.roseanyone.com.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import app.roseanyone.com.R
import app.roseanyone.com.activity.flower.AddFlowerActivity
import app.roseanyone.com.activity.flower.FlowerActivity
import app.roseanyone.com.fragment.cart.CartFragment
import app.roseanyone.com.fragment.home.HomeFragment
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.navigation_drawer_menu.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    companion object {
        var cartList = ArrayList<Flower>()
        fun newInstance(activity: Activity) {
            var intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            //  intent.putExtra("Splash", false)
            activity.startActivity(intent)

            activity.finish()
        }

        fun newInstance(activity: Activity, index: Int) {
            var intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("index", index)
            activity.startActivity(intent)

            activity.finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUI()
    }

    private fun setUI() {

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        toolbar.navigationIcon = null

        if (intent.extras != null) {
            bottomNavigation.selectedItemId = R.id.navigation_cart
        } else {
            bottomNavigation.selectedItemId = R.id.navigation_home
        }
        tvDrawerWeddingFlower.setOnClickListener {
            AddFlowerActivity.newInstance(this,tvDrawerWeddingFlower.text.toString())
        }
        tvDrawerOccasionsFlower.setOnClickListener {
            AddFlowerActivity.newInstance(this,tvDrawerOccasionsFlower.text.toString())
        }
        tvDrawerwomenFlower.setOnClickListener {
            AddFlowerActivity.newInstance(this,tvDrawerwomenFlower.text.toString())
        }

        tvDrawerAnniversary.setOnClickListener {
            AddFlowerActivity.newInstance(this,tvDrawerAnniversary.text.toString())
        }
        tvDrawerGift.setOnClickListener {
            AddFlowerActivity.newInstance(this,tvDrawerGift.text.toString())
        }
        tvDrawerWinner.setOnClickListener {
            AddFlowerActivity.newInstance(this,tvDrawerWinner.text.toString())
        }

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_menu -> {
                drawer_layout.openDrawer(GravityCompat.START)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                openHomeFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart -> {
                openCartFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun openHomeFragment() {
        var homeFragment = HomeFragment.newInstance()
        initializeFragment(homeFragment, R.id.main_container)
    }

    fun openCartFragment() {
        var fragment = CartFragment.newInstance()
        initializeFragment(fragment, R.id.main_container)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            /*   R.id.nav_camera -> {
                   // Handle the camera action
               }
               R.id.nav_gallery -> {

               }
               R.id.nav_slideshow -> {

               }
               R.id.nav_manage -> {

               }
              *//* R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }*/
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun initializeFragment(fragment: Fragment, id: Int) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(id, fragment, "")
        fragmentTransaction.commit()
    }
}
