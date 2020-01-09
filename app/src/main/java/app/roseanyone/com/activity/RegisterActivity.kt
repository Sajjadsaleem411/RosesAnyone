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
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUI()
    }

    private fun setUI() {
        btnRegister.setOnClickListener {
            //     register(etLoginFirstName)
            if (!etLoginFirstName.text.toString().isEmpty()) {
                if (etLoginEmail.text.toString().isValidEmail()) {
                    if (etLoginPassword.text.toString().length >= 6) {
                        register(
                            etLoginFirstName.text.toString(),
                            etLoginEmail.text.toString(), "",
                            etLoginPassword.text.toString()
                        )
                    } else {
                        Toast.makeText(this, resources.getString(R.string.passwordInvalid), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, resources.getString(R.string.emailInvalid), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, resources.getString(R.string.dataFieldsEmpty), Toast.LENGTH_SHORT).show()
            }
        }

        ivRegisterBack.setOnClickListener {
            finish()
        }
    }

    fun register(name: String, email: String, contact: String, password: String) {

        val dialog = CommonUtils.showLoadingDialog(this!!)

        val apiService =
            RosesApp.retrofit.create(ApiHelper::class.java)
        val call = apiService.Register(name, email, contact, "", password)
        call.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                var data = response.body()
                if (data?.status == 1) {
                    var loginInfo = data.userInfo

                    startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))


                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        resources.getString(R.string.emailAlreadyExist),
                        Toast.LENGTH_SHORT
                    ).show()
             //       Toast.makeText(this@RegisterActivity, data?.description, Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
                // ShowDirecton(data!!)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, t.toString(), Toast.LENGTH_SHORT).show()
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
