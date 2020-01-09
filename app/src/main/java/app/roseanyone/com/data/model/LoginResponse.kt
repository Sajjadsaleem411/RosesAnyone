package app.roseanyone.com.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {

    @SerializedName("userInfo")
    @Expose
    var userInfo: UserInfo? = null
    @SerializedName("Status")
    @Expose
    var status: Int? = null
    @SerializedName("Description")
    @Expose
    var description: String? = null

}