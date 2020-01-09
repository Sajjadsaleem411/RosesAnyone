package app.roseanyone.com.model

import java.io.Serializable

class Flower(pId: Int, pImage: Int, pPrice: Double,pTitle: String, pDesc: String, pQty: Int) : Serializable{
    var id: Int? = null
    var image: Int? = null
    var price: Double? = null
    var title: String? = null
    var desc: String? = null
    var qty: Int? = null

    // initializer block
    init {
        id = pId
        image = pImage
        price = pPrice
        desc = pDesc
        qty = pQty
        title=pTitle
    }
}