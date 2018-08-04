package com.bingoyo.customview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.LinearLayout;

public class FullScreenView extends LinearLayout {
    public FullScreenView(Context context) {
        super(context);
    }

    public FullScreenView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreenView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FullScreenView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setPadding(insets.getSystemWindowInsetLeft(), 0, insets.getSystemWindowInsetRight(),
                    insets.getSystemWindowInsetBottom());
            return insets.replaceSystemWindowInsets(0, insets.getSystemWindowInsetTop(), 0, 0);
        } else {
            return super.onApplyWindowInsets(insets);
        }
    }
}
