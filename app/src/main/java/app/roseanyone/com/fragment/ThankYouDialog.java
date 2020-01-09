package app.roseanyone.com.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.*;
import android.widget.RelativeLayout;
import app.roseanyone.com.R;
import app.roseanyone.com.activity.MainActivity;

public class ThankYouDialog extends DialogFragment implements View.OnClickListener {


    private static final String TAG = ThankYouDialog.class.getSimpleName();
    MainActivity mainActivity;

    public static ThankYouDialog newInstance() {
        ThankYouDialog fragment = new ThankYouDialog();
        return fragment;
    }

    public void dismissDialog() {
        dismiss();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_thankyou, container, false);

        setUI(view);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final RelativeLayout root = new RelativeLayout(getActivity());
       /* root.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));*/

        // creating the fullscreen dialog
        final Dialog dialog = new Dialog(getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setGravity(Gravity.CENTER);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
           /* dialog.getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);*/
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        }
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    public interface checkout_callback {
        void isCheckout(boolean flag);
    }


    private void setUI(View view) {

        view.findViewById(R.id.btnThankYouContinue).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnThankYouContinue:
                MainActivity.Companion.getCartList().clear();
                MainActivity.Companion.newInstance(getActivity());
                dismissDialog();
                break;
        }

    }

}