package com.bingoyo.authenticate;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.dashboard.home.HomeActivity;
import com.bingoyo.shownearestcountry.NearestCountryActivity;

import butterknife.OnClick;

public class ChangePassWordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            Drawable background = getResources().getDrawable(R.drawable.gradient_login_view);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
            getSupportActionBar().setBackgroundDrawable(background);

//            window.setBackgroundDrawable(background);
        }
        setContentView(R.layout.activity_change_pass_word);
        setButterKnife();
        setBackButtonEnabledAndTitle("Change Password");
    }


    @OnClick(R.id.save_password)
    public void onClick(View view) {

        startActivity(new Intent(this, HomeActivity.class));

    }
}
