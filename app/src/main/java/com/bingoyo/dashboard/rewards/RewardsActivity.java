package com.bingoyo.dashboard.rewards;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.bingoyo.R;
import com.bingoyo.ViewPagerAdapter;
import com.bingoyo.base.InitViewBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RewardsActivity extends InitViewBaseActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_rewards);
        setButterKnife();

        setBackButtonEnabledAndTitle("Rewards");


        intView();
    }

    @Override
    protected void intView() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);

        tabs.setupWithViewPager(viewPager);


        viewPagerAdapter.addFragment(new AvailableRewardsFragment(), "Available");
        viewPagerAdapter.addFragment(new RedeemedRewardFragment(), "Redeemed");

    }
}
