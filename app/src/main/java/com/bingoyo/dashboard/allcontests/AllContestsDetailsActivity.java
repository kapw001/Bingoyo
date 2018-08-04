package com.bingoyo.dashboard.allcontests;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.model.Contests;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllContestsDetailsActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.play)
    Button play;

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

        setContentView(R.layout.activity_all_contests_details);
        ButterKnife.bind(this);

        setButterKnife();


        Contests contests = (Contests) getIntent().getSerializableExtra("contest");

        setBackButtonEnabledAndTitle(contests.getName());

        name.setText(contests.getName());

        imageView.setClipToOutline(true);
    }


    @OnClick(R.id.play)
    public void onClick(View view) {

        Contests contests = (Contests) getIntent().getSerializableExtra("contest");

        Intent intent = new Intent(this, ContestDeatilsActivity.class);
        intent.putExtra("name", contests.getName());
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
