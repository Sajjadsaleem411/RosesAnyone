package app.roseanyone.com.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.*;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.roseanyone.com.R;

public class AddressDialog extends DialogFragment implements View.OnClickListener {



    public static AddressDialog newInstance() {
        AddressDialog fragment = new AddressDialog();
        return fragment;
    }

    public void dismissDialog() {
        dismiss();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_address, container, false);

        setUI(view);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final RelativeLayout root = new RelativeLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        // creating the fullscreen dialog
        final Dialog dialog = new Dialog(getContext());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setGravity(Gravity.BOTTOM);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        }
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public interface checkout_callback {
        void isCheckout(boolean flag);
    }


    private void setUI(View view) {


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

        }

    }

}