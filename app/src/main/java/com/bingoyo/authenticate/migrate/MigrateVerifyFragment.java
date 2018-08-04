package com.bingoyo.authenticate.migrate;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.bingoyo.R;
import com.bingoyo.ViewPagerAdapter;
import com.bingoyo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MigrateVerifyFragment extends BaseFragment {


    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;

    private ViewPagerAdapter viewPagerAdapter;

    public MigrateVerifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_migrate_verify, container, false);
        unbinder = ButterKnife.bind(this, view);

        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);

        tabs.setupWithViewPager(viewPager);

        viewPagerAdapter.addFragment(new VerifyOtpBySmsFragment(), "Verify OTP by SMS");
        viewPagerAdapter.addFragment(new VerifyOTPbyEmailFragment(), "Verify OTP by Email");


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
