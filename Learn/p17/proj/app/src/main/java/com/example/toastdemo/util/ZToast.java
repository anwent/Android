package com.example.toastdemo.util;

import android.content.Context;
import android.widget.Toast;

public class ZToast {

    public static Toast toast;

    public static void showMessage(Context ctx, String msg) {
        if (toast == null) {
            toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }


}
