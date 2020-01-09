package app.roseanyone.com.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.roseanyone.com.R
import app.roseanyone.com.fragment.ThankYouDialog
import kotlinx.android.synthetic.main.activity_address.*

class AddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        setUI()
    }

    private fun setUI() {
        ivAddressBack.setOnClickListener { finish() }

        btnAddressDone.setOnClickListener {
            ThankYouDialog.newInstance()
                .show(supportFragmentManager)
        }
    }
}
