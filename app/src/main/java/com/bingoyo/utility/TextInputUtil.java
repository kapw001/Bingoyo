package com.bingoyo.utility;

import android.content.res.ColorStateList;
import android.support.design.widget.TextInputLayout;


public class TextInputUtil {


    public static String getText(TextInputLayout inputLayout){
        return inputLayout.getEditText().getText().toString();
    }


    public static void setError(TextInputLayout inputLayout, String errorMsg, int style) {

        inputLayout.setErrorTextAppearance(style);
        inputLayout.setErrorEnabled(true);
        inputLayout.setError(errorMsg);


    }

    public static void setErrorFocusable(TextInputLayout inputLayout, String errorMsg, int style) {

        inputLayout.setErrorTextAppearance(style);
        inputLayout.setErrorEnabled(true);
        inputLayout.setError(errorMsg);
//        inputLayout.setFocusable(false);
//        inputLayout.setFocusableInTouchMode(false);
//        inputLayout.setHintEnabled(true);
//        inputLayout.setHint("Mobile");


    }

    public static void setError(TextInputLayout inputLayout, String errorMsg) {
//        inputLayout.setHintTextAppearance(R.style.before_error_appearance);
        inputLayout.setErrorEnabled(true);
        inputLayout.setError(errorMsg);
//        inputLayout.setHintEnabled(false);
//        inputLayout.setHintTextAppearance(R.style.Inactive);


    }

    public static void setDisableError(TextInputLayout inputLayout) {

        inputLayout.setError(null);
        inputLayout.setErrorEnabled(false);

    }
}
