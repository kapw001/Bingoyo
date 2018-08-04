package com.bingoyo.base;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.bingoyo.R;

public abstract class InitViewBaseActivity extends BaseActivity {


    protected abstract void intView();


    public void setFullScreenGradientColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            Drawable background = getResources().getDrawable(R.drawable.gradient_login_view);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
            getSupportActionBar().setBackgroundDrawable(background);

//            window.setBackgroundDrawable(background);
        }
    }

}
