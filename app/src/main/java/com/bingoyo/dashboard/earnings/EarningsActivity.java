package com.bingoyo.dashboard.earnings;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.ViewPagerAdapter;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.customview.EarningsPointView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EarningsActivity extends InitViewBaseActivity implements ViewChangeCallBack {

    @BindView(R.id.gemsPoints)
    EarningsPointView gemsPoints;
    @BindView(R.id.inventory)
    EarningsPointView inventory;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.artifect)
    TextView artifect;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_earnings);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Earnings");

        intView();
    }

    @Override
    protected void intView() {


        inventory.setTitle("In the Inventory");
        inventory.setPoints("1070");


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);

        tabs.setupWithViewPager(viewPager);

        viewPagerAdapter.addFragment(new HistoryEarningsFragment(), "History");
        viewPagerAdapter.addFragment(new ZonalEarningsFragment(), "Zonal level");
        viewPagerAdapter.addFragment(new SponserEarningsFragment(), "Sponser level");
    }


    @Override
    public void onZonalCallBack() {

        inventory.setVisibility(View.GONE);
        artifect.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHistoryCallBack() {
        inventory.setVisibility(View.VISIBLE);
        artifect.setVisibility(View.GONE);
    }

    @Override
    public void onSponzerCallBack() {

    }
}
