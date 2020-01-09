package app.roseanyone.com.activity.flower

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.roseanyone.com.R
import app.roseanyone.com.activity.flower.FlowerActivity
import app.roseanyone.com.model.Flower
import kotlinx.android.synthetic.main.item_flower_activity.view.*


class FlowerActicityAdpater// data is passed into the constructor
internal constructor(private val context: Activity, private val mData: List<Flower>) :
    RecyclerView.Adapter<FlowerActicityAdpater.ViewHolder>() {
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

        val view = mInflater.inflate(R.layout.item_flower_activity, parent, false)
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
        holder.ivOffer!!.setImageResource(data.image!!)
        holder.tvTitle!!.text=data.title!!
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
        var tvTitle: TextView?=null

        init {
            itemView.setOnClickListener(this)
            ivOffer = itemView.ivItemFlower
            tvTitle = itemView.tvItemFlowerTitle
        }

        override fun onClick(view: View) {
            AddFlowerActivity.newInstance(context,mData[adapterPosition].title!!)
          /*  val intent = Intent(context, AddFlowerActivity::class.java)
               intent.putExtra("category", mData[adapterPosition].title)
//            intent.putExtra("CarID", mData[adapterPosition].vehicleID!!.toString())

            context.startActivity(intent)*/
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