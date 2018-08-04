package com.bingoyo.utility;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressUtils {

    private static final String TAG = "ProgressUtils";
    private static ProgressDialog progressDialog;
    public static void showProgress(Context context, String msg) {

        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    public static void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
//            progressDialog = null;
        }
    }
}
