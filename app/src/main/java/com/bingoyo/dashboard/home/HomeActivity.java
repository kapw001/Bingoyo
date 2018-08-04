package com.bingoyo.dashboard.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.dashboard.allcontests.AllContestsActivity;
import com.bingoyo.dashboard.earnings.EarningsActivity;
import com.bingoyo.dashboard.editprofile.EditProfile;
import com.bingoyo.dashboard.leaderboard.LeaderBoardActivity;
import com.bingoyo.dashboard.mycontests.MyContestsActivity;
import com.bingoyo.dashboard.mygroup.MyGroupActivity;
import com.bingoyo.dashboard.rewards.RewardsActivity;
import com.bingoyo.dashboard.settings.SettingsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.profile)
    ImageView profile;
    @BindView(R.id.dash_all_contests)
    CardView dashAllContests;
    @BindView(R.id.dash_my_contests)
    CardView dashMyContests;
    @BindView(R.id.dash_my_leaderboard)
    CardView dashMyLeaderboard;
    @BindView(R.id.dash_my_rewards)
    CardView dashMyRewards;
    @BindView(R.id.dash_my_groups)
    CardView dashMyGroups;
    @BindView(R.id.dash_my_earnings)
    CardView dashMyEarnings;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            Drawable background = getResources().getDrawable(R.drawable.gradient_login_view);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
//            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
//            getSupportActionBar().setBackgroundDrawable(background);
//
////            window.setBackgroundDrawable(background);
//        }


        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Dashboard");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        profile.setClipToOutline(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.dash_all_contests, R.id.dash_my_contests, R.id.dash_my_rewards, R.id.dash_my_earnings, R.id.dash_my_groups, R.id.dash_my_leaderboard, R.id.profile})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.dash_all_contests:

                startActivity(new Intent(this, AllContestsActivity.class));

                break;

            case R.id.dash_my_contests:

                startActivity(new Intent(this, MyContestsActivity.class));

                break;

            case R.id.dash_my_rewards:

                startActivity(new Intent(this, RewardsActivity.class));

                break;

            case R.id.dash_my_earnings:

                startActivity(new Intent(this, EarningsActivity.class));

                break;

            case R.id.dash_my_groups:

                startActivity(new Intent(this, MyGroupActivity.class));

                break;

            case R.id.dash_my_leaderboard:

                startActivity(new Intent(this, LeaderBoardActivity.class));

                break;

            case R.id.profile:

                startActivity(new Intent(this, EditProfile.class));

                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (item.getItemId() == R.id.settings) {

            startActivity(new Intent(this, SettingsActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
