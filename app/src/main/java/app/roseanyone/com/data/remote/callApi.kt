package app.roseanyone.com.data.remote

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import app.roseanyone.com.R
import app.roseanyone.com.RosesApp
import app.roseanyone.com.data.model.LoginResponse
import app.roseanyone.com.utils.CommonUtils
import retrofit2.Call
import retrofit2.Response

class callApi
internal constructor(private val context: Activity)  {
    fun login(email: String, password: String) {

        //   if (NetworkUtils.isNetworkConnected(context)) {
        val dialog = CommonUtils.showLoadingDialog(context!!)

        val apiService =
            RosesApp.retrofit.create(ApiHelper::class.java)
        val call = apiService.Login(email, password)
        call.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                var data = response.body()
                if (data?.status==1) {
                    var loginInfo = data.userInfo

                } else {
                 //   Toast.makeText(context, context!!.resources.getString(R.string.passwordOrEmailInvalid), Toast.LENGTH_SHORT).show()
                    //  Toast.makeText(context, context!!.resources.getString(R.string.invalidData), Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
                // ShowDirecton(data!!)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()

//                    Toast.makeText(context, context!!.resources.getString(R.string.internetError), Toast.LENGTH_SHORT).show()

                dialog.dismiss()
                // Log error here since request failed
                Log.e("data", t.toString())
            }
        })
        //  }
    }
}
