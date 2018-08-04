package com.bingoyo.dashboard.allcontests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingoyo.R;
import com.bingoyo.ViewPagerAdapter;
import com.bingoyo.base.BaseFragment;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HowToPlayFragment extends BaseFragment {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.pageIndicatorView)
    PageIndicatorView pageIndicatorView;
    Unbinder unbinder;


    private ViewPagerAdapter viewPagerAdapter;

    public HowToPlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_how_to_play, container, false);
        unbinder = ButterKnife.bind(this, view);


        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);

        viewPagerAdapter.addFragment(new HowToPlayDeatilsFragment(), "HowToPlay");
        viewPagerAdapter.addFragment(new HowToPlayDeatilsFragment(), "HowToPlay");
        viewPagerAdapter.addFragment(new HowToPlayDeatilsFragment(), "HowToPlay");
        viewPagerAdapter.addFragment(new HowToPlayDeatilsFragment(), "HowToPlay");
        viewPagerAdapter.addFragment(new HowToPlayDeatilsFragment(), "HowToPlay");


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
