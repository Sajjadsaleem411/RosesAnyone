package app.roseanyone.com.fragment.home

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import app.roseanyone.com.R
import kotlinx.android.synthetic.main.item_offer.view.*


class offerAdpater// data is passed into the constructor
internal constructor(private val context: Activity, private val mData: List<Int>) : RecyclerView.Adapter<offerAdpater.ViewHolder>() {
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null
    private val width: Int
    private val height: Int


    init {
        this.mInflater = LayoutInflater.from(context)
        var displayMetrics = DisplayMetrics()

        displayMetrics = context.resources.displayMetrics
        height = displayMetrics.heightPixels
        width = displayMetrics.widthPixels

    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cellWidth = width.toDouble()
        val cellHeight = height * 0.15

        val view = mInflater.inflate(R.layout.item_offer, parent, false)
        /*    LinearLayout imageView = view.findViewById(R.id.ll_item_econmyCar);
        // Set height and width constraints for the image view
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) cellWidth, (int) cellHeight));

        // Set Padding for images
        imageView.setPadding(1, 1, 1, 1);*/

        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = this.mData[position]
        holder.ivOffer!!.setImageResource(data)
     /*   holder.name?.text=data.vehiclesTitle
        holder.price?.text="$${data.pricePerDay}"
        holder.model?.text=data.modelYear
        Picasso.get().load(mData[position].carImages[0].imagePath).into(holder.carImage)*/

    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }


    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var ivOffer: ImageView? = null

        init {
            ivOffer=itemView.ivItemOffer
          /*  itemView.setOnClickListener(this)
            name=itemView.tvEconomyCarName
            model=itemView.tvEconomyCarModel
            price=itemView.tvEconomyCarPrice
            seats=itemView.tvEconomyCarSeats
            manual=itemView.tvEconomyCarManual
            carImage=itemView.ivCarImage*/

        }

        override fun onClick(view: View) {
         /*   val intent = Intent(context, CarDetailActivity::class.java)
            intent.putExtra("BrandID", brandID)
            intent.putExtra("CarID", mData[adapterPosition].vehicleID!!.toString())

            context.startActivity(intent)
            context.overridePendingTransition(R.anim.enter, R.anim.exit)*/
        }
    }


    // allows clicks events to be caught
    internal fun setClickListener(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}