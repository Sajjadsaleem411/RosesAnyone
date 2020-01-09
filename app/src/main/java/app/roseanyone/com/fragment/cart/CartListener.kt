package app.roseanyone.com.fragment.cart

import android.view.View

interface CartListener {
    abstract fun deleteItem( position: Int)
    abstract fun increseQty( position: Int,qty: Int)
}