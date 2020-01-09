package app.roseanyone.com.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.roseanyone.com.R
import kotlinx.android.synthetic.main.activity_language.*

class LanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        setContentView(R.layout.activity_language)
        setUI()
    }
    private fun setUI(){
        btnLanguageEnglish.setOnClickListener {
           LaunchActivity.newInstance(this)
        }
        btnLanguageArabic.setOnClickListener {
            LaunchActivity.newInstance(this) }
    }
}
