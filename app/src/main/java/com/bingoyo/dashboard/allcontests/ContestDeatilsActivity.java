package com.bingoyo.dashboard.allcontests;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.ViewPagerAdapter;
import com.bingoyo.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContestDeatilsActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_bar)
    RelativeLayout layoutBar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.count_down)
    TextView countDown;
    @BindView(R.id.name)
    TextView name;

    private ViewPagerAdapter viewPagerAdapter;

    private Timer timer;

    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_deatils);
        ButterKnife.bind(this);


        Intent intent = getIntent();

        if (intent != null) {


            if (intent.hasExtra("name")) {

                String nametxt = intent.getStringExtra("name");

                name.setText(nametxt + " details");
            }

        }


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);

        tabs.setupWithViewPager(viewPager);

        viewPagerAdapter.addFragment(new AboutContestFragment(), "About the contest");
        viewPagerAdapter.addFragment(new HowToPlayFragment(), "How to play");

        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                count--;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        countDown.setText(count + "");
                    }
                });

                if (count == 0) {
                    timer.cancel();

                    startActivity(new Intent(getApplicationContext(), ContestBeginPageActivity.class));
                }

            }
        }, 1000, 1000);


    }


    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) {
            timer.cancel();
        }
    }

    @OnClick(R.id.back)
    public void onClick(View view) {

        onBackPressed();
    }
}
