package app.roseanyone.com.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.roseanyone.com.R
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {
    companion object {
        fun newInstance(activity: Activity) {
            var intent = Intent(activity, LaunchActivity::class.java)
            //     intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
          //  intent.putExtra("Splash", false)
            activity.startActivity(intent)

            activity.finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_launch)
        setUI()
    }
    private fun setUI(){
        btnLaunchLogin.setOnClickListener {
            startActivity(Intent(this@LaunchActivity,LoginActivity::class.java))
        }
        btnLaunchRegister.setOnClickListener {
            startActivity(Intent(this@LaunchActivity,RegisterActivity::class.java))
        }
    }
}
