package app.roseanyone.com.activity.flower;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import app.roseanyone.com.R;
import app.roseanyone.com.activity.MainActivity;
import app.roseanyone.com.model.Flower;

import java.util.ArrayList;
import java.util.List;


public class AddFlowerAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    AddFlowerActivity context;
    private List<Flower> tList;
    int height, width;


    public AddFlowerAdapter(AddFlowerActivity context, List<Flower> tList) {
        this.context = context;
        this.tList = tList;
        if (context != null) {
            layoutInflater = LayoutInflater.from(context);
        }
        notifyDataSetChanged();

        DisplayMetrics displayMetrics = new DisplayMetrics();


        displayMetrics = context.getResources().getDisplayMetrics();
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        Log.d("tag", "" + width + "" + height);
    }

    @Override
    public int getCount() {
        if (tList == null)
            return 0;

        return tList.size();
    }

    @Override
    public Object getItem(int position) {
        return tList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        double cellWidth = width*0.5 ;
        double cellHeight = height * 0.33;
        final Flower flower=tList.get(position);
        if (convertView == null) {
            holder= new ViewHolder();
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item_add_flower, null);
            holder.addCart = (TextView) convertView.findViewById(R.id.tvAddFlowerCart);
            holder.desc = (TextView) convertView.findViewById(R.id.tvAddFlowerDesc);
            holder.price = (TextView) convertView.findViewById(R.id.tvAddFlowerPrice);
            holder.image = (ImageView) convertView.findViewById(R.id.ivAddFlower);
            convertView.setLayoutParams(new LinearLayout.LayoutParams((int) cellWidth, (int) cellHeight));
            convertView.setPadding(1, 1, 1, 1);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
       /* row.setLayoutParams(params);
        LinearLayout imageView = convertView.findViewById(R.id.llAddFlower);*/
        // Set height and width constraints for the image view

        // Set Padding for images
        holder.desc.setText(flower.getDesc());
        holder.price.setText("$ "+flower.getPrice());
        holder.image.setImageResource(flower.getImage());
        holder.addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Flower> list= MainActivity.Companion.getCartList();
                list.add(flower);
                MainActivity.Companion.setCartList(list);
                Toast.makeText(context,"Added flower in cart", Toast.LENGTH_SHORT).show();
               /* Snackbar.make(view, "Added flower in cart", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).setActionTextColor(context.getResources().getColor(R.color.white)).show();
          */      context.setToolbarCart();

            }
        });


      /*  holder.itemText = (TextView) convertView.findViewById(R.id.btn_gridview_item);
        holder.image = (ImageView) convertView.findViewById(R.id.img_gridview_item);
        holder.check = (ImageView) convertView.findViewById(R.id.iv_gridview_check);
        Picasso.get().load(item.getImageURL())
                .resize(CommonUtils.imageDimentionX, CommonUtils.imageDimentionY)
                .placeholder(R.drawable.default_thumb_image)
                .error(R.drawable.default_thumb_image).into(holder.image);

        holder.itemText.setText(CommonUtils.breakString(item.getName(),14));
        if (item.getShortcut()) {
            holder.check.setVisibility(View.VISIBLE);
        } else {
            holder.check.setVisibility(View.GONE);

        }*/
        //        getMyView(position, holder.itemText, holder.image, parent, tList.get(position));
        return convertView;
    }


    class ViewHolder {
        TextView addCart;
        TextView desc;
        TextView price;
        ImageView image;
    }

}