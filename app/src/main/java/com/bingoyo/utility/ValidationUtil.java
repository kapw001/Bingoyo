package com.bingoyo.utility;

import android.text.TextUtils;
import android.util.Patterns;

public class ValidationUtil {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public static boolean isValidInput(CharSequence target) {
        return !TextUtils.isEmpty(target);
    }

    public static boolean isValidMobile(CharSequence target) {
        return (!TextUtils.isEmpty(target) && !(target.length()>=10));
    }

}
