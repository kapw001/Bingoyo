package com.bingoyo.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bingoyo.ProgressUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yasar on 26/3/18.
 */

public class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";


    private Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        loge("onAttach Fragment");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


        loge("onCreate Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loge("onCreateView Fragment");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loge("onViewCreated Fragment");
    }

    public void setButterKnife(Fragment fragment, View view) {
        unbinder = ButterKnife.bind(fragment, view);
    }

    @Override
    public void onStart() {
        super.onStart();

        loge("onStart Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();

        loge("onPause Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();

        loge("onResume Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();

        loge("onStop Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (unbinder != null) {
            unbinder.unbind();
        }
        loge("onDestroyView Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        loge("onDestroy Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        loge("onDetach Fragment");
    }
//    @Override
//    public boolean onTouch(View v, MotionEvent motionEvent) {
//        int action = motionEvent.getAction();
//        if (action == MotionEvent.ACTION_DOWN) {
//            v.animate().scaleXBy(100f).setDuration(5000).start();
//            v.animate().scaleYBy(100f).setDuration(5000).start();
//            return true;
//        } else if (action == MotionEvent.ACTION_UP) {
//            v.animate().cancel();
//            v.animate().scaleX(1f).setDuration(1000).start();
//            v.animate().scaleY(1f).setDuration(1000).start();
//            return true;
//        }
//
//        return false;
//    }

    protected void onTouchScaleDown(View v, MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(v,
                        "scaleX", 0.9f);
                ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(v,
                        "scaleY", 0.9f);
                scaleDownX.setDuration(50);
                scaleDownY.setDuration(50);

                AnimatorSet scaleDown = new AnimatorSet();
                scaleDown.play(scaleDownX).with(scaleDownY);

                scaleDown.start();

                break;

            case MotionEvent.ACTION_UP:

                ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                        v, "scaleX", 1f);
                ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                        v, "scaleY", 1f);
                scaleDownX2.setDuration(100);
                scaleDownY2.setDuration(100);

                AnimatorSet scaleDown2 = new AnimatorSet();
                scaleDown2.play(scaleDownX2).with(scaleDownY2);

                scaleDown2.start();
                onClick(v);

                break;

            case MotionEvent.ACTION_CANCEL:

                ObjectAnimator scaleDownX3 = ObjectAnimator.ofFloat(
                        v, "scaleX", 1f);
                ObjectAnimator scaleDownY3 = ObjectAnimator.ofFloat(
                        v, "scaleY", 1f);
                scaleDownX3.setDuration(100);
                scaleDownY3.setDuration(100);

                AnimatorSet scaleDown3 = new AnimatorSet();
                scaleDown3.play(scaleDownX3).with(scaleDownY3);
                scaleDown3.start();

                break;
        }


//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            // scale your value
//            float reducedvalue = (float) 0.9;
//            v.setScaleX(reducedvalue);
//            v.setScaleY(reducedvalue);
//        } else if (event.getAction() == MotionEvent.ACTION_UP) {
//            v.setScaleX(1);
//            v.setScaleY(1);
//            onClick(v);
//        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
//            v.setScaleX(1);
//            v.setScaleY(1);
//        }
    }

    protected void onClick(View v) {
    }


    public int getColor(@ColorRes int colorId) {
        return ContextCompat.getColor(getActivity(), colorId);
    }


    public void showSnackBar(View view, String msg) {

        Snackbar snackbar = Snackbar
                .make(view, msg, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    public void onSuccess(Object object) {
        hideLoading();
    }

    public void onFail(Throwable throwable) {
        hideLoading();
//        Toast.makeText(getContext(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();

//        progressStateCall(R.drawable.somethingwentwrong, "error");
    }


    public void onNetworkFailure() {
        hideLoading();
        Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
//        progressStateCall(R.drawable.nointernet, "nointernet");

    }


    public void showLoading() {

        ProgressUtils.showProgress(getContext(), "Loading");

//        progressStateCall(R.drawable.nointernet, "loading");

    }


    public void hideLoading() {

        ProgressUtils.hideProgress();
//        progressStateCall(R.drawable.nointernet, "content");

    }


    public void showToast(String msg) {

        Toast.makeText(getContext(), "" + msg
                , Toast.LENGTH_SHORT).show();

    }


    public void showToast(@StringRes int msgID) {

        Toast.makeText(getContext(), "" + msgID, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
////            String yes = getString(R.string.yes);
////            String no = getString(R.string.no);
////
////            // Do something after user returned from app settings screen, like showing a Toast.
////            Toast.makeText(
////                    this,
////                    getString(R.string.returned_from_app_settings_to_activity,
////                            hasCameraPermission() ? yes : no,
////                            hasLocationAndContactsPermissions() ? yes : no,
////                            hasSmsPermission() ? yes : no),
////                    Toast.LENGTH_LONG)
////                    .show();
//        }
    }


    public View.OnClickListener errorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callNetwork();
        }
    };

    public void callNetwork() {

    }


    public void loge(String message) {

        Log.e(TAG, "loge: " + message);

    }

    public void logi(String message) {

        Log.i(TAG, "logi: " + message);

    }

    public void logv(String message) {

        Log.v(TAG, "logv: " + message);

    }


    public String getText(TextInputLayout inputLayout) {

        return inputLayout.getEditText().getText().toString();
    }


}
