package com.bingoyo.dashboard.leaderboard;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.bingoyo.R;
import com.bingoyo.ViewPagerAdapter;
import com.bingoyo.base.InitViewBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaderBoardActivity extends InitViewBaseActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.pager)
    ViewPager pager;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_leader_board);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Leaderboard");
        intView();
    }

    @Override
    protected void intView() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(viewPagerAdapter);

        tabs.setupWithViewPager(pager);

        viewPagerAdapter.addFragment(new FriendsFragment(), "Friends");
        viewPagerAdapter.addFragment(new PublicFragment(), "Public");

    }
}
