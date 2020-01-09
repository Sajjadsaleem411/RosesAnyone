package app.roseanyone.com.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import app.roseanyone.com.R
import app.roseanyone.com.RosesApp
import app.roseanyone.com.data.model.LoginResponse
import app.roseanyone.com.data.remote.ApiHelper
import app.roseanyone.com.utils.CommonUtils
import app.roseanyone.com.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUI()
    }

    private fun setUI() {
        btnLogin.setOnClickListener {
            if (etLoginEmail.text.toString().isValidEmail()) {
                if (!etLoginPassword.text.toString().isEmpty()) {
                    if (NetworkUtils.isNetworkConnected(this)) {
                        login(etLoginEmail.text.toString(), etLoginPassword.text.toString())
                    }
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        resources.getString(R.string.passwordInvalid),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            } else {
                Toast.makeText(this@LoginActivity, resources.getString(R.string.emailInvalid), Toast.LENGTH_SHORT)
                    .show()
            }

        }
        tvLoginRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()


        }
        ivLoginBack.setOnClickListener {
            finish()
        }
    }

    fun login(email: String, password: String) {

        val dialog = CommonUtils.showLoadingDialog(this!!)

        val apiService =
            RosesApp.retrofit.create(ApiHelper::class.java)
        val call = apiService.Login(email, password)
        call.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                var data = response.body()
                if (data?.status == 1) {
                    var loginInfo = data.userInfo

                    MainActivity.newInstance(this@LoginActivity)

                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        resources.getString(R.string.passwordOrEmailInvalid),
                        Toast.LENGTH_SHORT
                    ).show()

                }
                dialog.dismiss()
                // ShowDirecton(data!!)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.toString(), Toast.LENGTH_SHORT).show()

//                    Toast.makeText(context, context!!.resources.getString(R.string.internetError), Toast.LENGTH_SHORT).show()

                dialog.dismiss()
                // Log error here since request failed
                Log.e("data", t.toString())
            }
        })
        //  }
    }

    fun String.isValidEmail(): Boolean = this.isNotEmpty() &&
            Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
