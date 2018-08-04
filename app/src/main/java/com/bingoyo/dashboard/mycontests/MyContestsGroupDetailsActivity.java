package com.bingoyo.dashboard.mycontests;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.dashboard.allcontests.ContestDeatilsActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyContestsGroupDetailsActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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

        setContentView(R.layout.activity_my_group_contests_details);

        setButterKnife();
        setBackButtonEnabledAndTitle("Talent Bridge Contest");

        imageView.setClipToOutline(true);
    }


    @OnClick(R.id.play)
    public void onClick(View view) {

        startActivity(new Intent(this, ContestDeatilsActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
