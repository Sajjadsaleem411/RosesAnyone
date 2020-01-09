package app.roseanyone.com.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserInfo {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("contact")
    @Expose
    var contact: String? = null
    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null
    @SerializedName("pswd")
    @Expose
    var pswd: String? = null

}