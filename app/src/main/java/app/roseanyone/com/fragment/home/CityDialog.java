package app.roseanyone.com.fragment.home;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import app.roseanyone.com.R;

public class CityDialog implements View.OnClickListener {
    Dialog dialog;
    Context context;
    private TextView tvNumber, tvCurrency;
    int position;

    public CityDialog(Context context, int[] location, int position) {
        this.context = context;
        this.position = position;
        dialog = new Dialog(context); // Context, this, etc.
        dialog.setContentView(R.layout.dialog_city);
        //dialog.setTitle(msg);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        Window window = dialog.getWindow();

        window.setGravity(Gravity.BOTTOM | Gravity.CENTER);

        wmlp.x = location[0];   //x position
        wmlp.y = location[1];   //y position

        Log.d("Location", "x=" + location[0] + ",Y=" + location[1]);

        dialog.setCancelable(true);
        setUI(dialog);
    }

    public void showDiallog() {
        dialog.show();
    }

    private void setUI(Dialog view) {

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

        }
    }


}
