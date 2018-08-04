package com.bingoyo.utility;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppUtils {

    public static void playVideoMsg(Activity context, String url) {
        Intent videoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (context.getPackageManager().resolveActivity(videoIntent, videoIntent.getFlags()) != null) {
            context.startActivity(videoIntent);
        }
    }

    public static String getDateFormattedText(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String dateString = formatter.format(date);
        return dateString;
    }
}
