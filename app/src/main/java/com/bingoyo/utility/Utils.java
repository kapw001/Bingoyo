package com.bingoyo.utility;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.widget.DatePicker;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class Utils {


    public static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public static void loadImage(ImageView imageView, String url) {

//        if (url != null && url.length() > 0)
//            Picasso.get().load(url).resize(200, 200).centerCrop().placeholder(R.drawable.progress_animation).error(R.drawable.not_found).into(imageView);
//        else Picasso.get().load(R.drawable.not_found).into(imageView);


    }

    public static void loadFullImage(ImageView imageView, String url) {


//        if (url != null && url.length() > 0)
//            Picasso.get().load(url).error(R.drawable.not_found).placeholder(R.drawable.progress_animation).into(imageView);
//        else Picasso.get().load(R.drawable.not_found).into(imageView);


    }


    public static Bitmap getBitmapFromURL(final String imageUrl, final BitmapFactory.Options options, int reqWidth, int reqHeight) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            final InputStream input = connection.getInputStream();
            // using byte array to prevent open 2 times a stream
            final BufferedInputStream bis = new BufferedInputStream(input, 4 * 1024);
            ByteArrayOutputStream baf = new ByteArrayOutputStream(50);
//            int current = 0;
//            while ((current = bis.read()) != -1) {
//                baf.append((byte)current);
//            }

            byte[] data = new byte[50];
            int current = 0;

            while ((current = bis.read(data, 0, data.length)) != -1) {
                baf.write(data, 0, current);
            }

            bis.close();
            byte[] imageData = baf.toByteArray();
            if (options != null) {
                // First decode with inJustDecodeBounds=true to check dimensions
                final BitmapFactory.Options optionsSize = new BitmapFactory.Options();
                optionsSize.inJustDecodeBounds = true;


                BitmapFactory.decodeByteArray(imageData, 0, imageData.length, optionsSize);

                // Calculate inSampleSize
                options.inSampleSize = calculateInSampleSize(optionsSize, reqWidth, reqHeight);

                // Decode bitmap with inSampleSize set
                optionsSize.inJustDecodeBounds = false;

            }
            Bitmap myBitmap = null;
            if (options == null) {
                myBitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
            } else {
                myBitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
            }
            // close the stream;
            input.close();
            return myBitmap;
        } catch (Exception e) {
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

//    public static TextDrawable getTextDrawable(String title) {
//
//        String c = String.valueOf(title.charAt(0)).toUpperCase();
//        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
//
//        int color = generator.getColor(title);
//
//        TextDrawable drawable = TextDrawable.builder()
//                .buildRound(c, color);
//
//        return drawable;
//    }
//
//
//    public static ArrayList<SampleSearchModel> createSampleData() {
//        ArrayList<SampleSearchModel> items = new ArrayList<>();
//        items.add(new SampleSearchModel("First item"));
//        items.add(new SampleSearchModel("Second item"));
//        items.add(new SampleSearchModel("Third item"));
//        items.add(new SampleSearchModel("The ultimate item"));
//        items.add(new SampleSearchModel("Last item"));
//        items.add(new SampleSearchModel("Lorem ipsum"));
//        items.add(new SampleSearchModel("Dolor sit"));
//        items.add(new SampleSearchModel("Some random word"));
//        items.add(new SampleSearchModel("guess who's back"));
//
//        items.add(new SampleSearchModel("First item"));
//        items.add(new SampleSearchModel("Second item"));
//        items.add(new SampleSearchModel("Third item"));
//        items.add(new SampleSearchModel("The ultimate item"));
//        items.add(new SampleSearchModel("Last item"));
//        items.add(new SampleSearchModel("Lorem ipsum"));
//        items.add(new SampleSearchModel("Dolor sit"));
//        items.add(new SampleSearchModel("Some random word"));
//        items.add(new SampleSearchModel("guess who's back"));
//
//        return items;
//    }
//
//
//    public static void callDatePicker(FragmentManager fragmentManager, final DateCallBack dateCallBack) {
//
//        Bundle bundle = new Bundle();
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.DATE, 1);
//        bundle.putInt("year", c.get(Calendar.YEAR));
//        bundle.putInt("month", c.get(Calendar.MONTH));
//        bundle.putInt("day", c.get(Calendar.DAY_OF_MONTH));
//        DatePickerFragment fragment = DatePickerFragment
//                .newInstance(bundle);
//        fragment.setCallBack(new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                dateCallBack.showDate(dayOfMonth + "-" + (month + 1) + "-" + year);
////
////                showToast(dayOfMonth + "-" + (month + 1) + "-" + year);
//            }
//        });
//        fragment.show(fragmentManager, null);
//
//
//    }


    public static RecyclerView.OnScrollListener fabShowHide(final FloatingActionButton mFab) {

        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    mFab.hide();
                } else {
                    mFab.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        };
    }


    public interface DateCallBack {

        void showDate(String date);
    }
}
