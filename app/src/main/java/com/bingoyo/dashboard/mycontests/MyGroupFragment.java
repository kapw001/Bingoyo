package com.bingoyo.dashboard.mycontests;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingoyo.R;
import com.bingoyo.base.BaseFragment;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.model.Contests;
import com.bingoyo.model.MyContests;
import com.bingoyo.model.MyGroupContests;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGroupFragment extends BaseFragment {

    private static final String TAG = "CurrentFragment";
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.myContestsListView)
    RecyclerView myContestsListView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;

    public MyGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        loadDataByUpComing();
        return view;
    }


    private void initView() {

        tabs.getTabAt(0).setText("Upcoming");
        tabs.getTabAt(1).setText("Past");

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                if (tab.getPosition() == 0) {
                    loadDataByUpComing();
                } else {
                    loadDataByPast();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());


        myContestsListView.setLayoutManager(new LinearLayoutManager(getContext()));

        myContestsListView.setAdapter(recyclerViewAdapter);


        recyclerViewAdapter.setCallBackValue(new RecyclerViewAdapter.CallBackValue<MyGroupContests>() {
            @Override
            public void onItemClickValue(View view, MyGroupContests o, int position) {
                Log.e(TAG, "onItemClick: " + position + "   " + o.toString());

                Intent intent = new Intent(getContext(), MyContestsGroupDetailsActivity.class);

                startActivity(intent);
            }
        });

//        loadDataByUpComing();

    }


    private void loadDataByUpComing() {


        List allContestList = new ArrayList<>();

        MyContests allContest = new MyContests();
        allContest.setMyGroup(true);
        allContest.setTitle("Today");


        List contestsList = new ArrayList<>();
        MyGroupContests contests = new MyGroupContests();
        contests.setName("Modi Facts");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Facebook Quiz");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Firebase Test");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Unity Cetificate");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);


        allContest.setMyGroupContestsList(contestsList);

        allContestList.add(allContest);

        allContest = new MyContests();
        allContest.setMyGroup(true);
        allContest.setTitle("Tomorrow");


        List<MyGroupContests> contestsList1 = new ArrayList<>();
        contests = new MyGroupContests();
        contests.setName("Modi Facts");
        contests.setTime("Contest starts in 2 days");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("Contest starts in 5 days");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 1 month");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setName("Facebook Quiz");
        contests.setTime("Contest starts in 10 days");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setName("Firebase Test");
        contests.setTime("Contest starts in 20 Mins");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setName("Unity Cetificate");
        contests.setTime("Contest starts in 20 Mins");
        contestsList1.add(contests);

        allContest.setMyGroupContestsList(contestsList1);

        allContestList.add(allContest);

        recyclerViewAdapter.clearAndAddNewData(allContestList);

    }


    private void loadDataByPast() {


        List allContestList = new ArrayList<>();

        MyContests allContest = new MyContests();
        allContest.setMyGroup(true);
        allContest.setTitle("Yesterday");


        List contestsList = new ArrayList<>();
        MyGroupContests contests = new MyGroupContests();
        contests.setName("Modi Facts");
        contests.setCloseEnabled(true);
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("Contest starts in 20 Minutes");
        contests.setCloseEnabled(true);
        contestsList.add(contests);

        contests = new MyGroupContests();
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 20 Minutes");
        contests.setCloseEnabled(true);
        contestsList.add(contests);

//        contests = new Contests();
//        contests.setName("Facebook Quiz");
//        contests.setTime("Contest starts in 20 Minutes");
//        contestsList.add(contests);
//
//        contests = new Contests();
//        contests.setName("Firebase Test");
//        contests.setTime("Contest starts in 20 Minutes");
//        contestsList.add(contests);
//
//        contests = new Contests();
//        contests.setName("Unity Cetificate");
//        contests.setTime("Contest starts in 20 Minutes");
//        contestsList.add(contests);


        allContest.setMyGroupContestsList(contestsList);

        allContestList.add(allContest);

        allContest = new MyContests();
        allContest.setMyGroup(true);
        allContest.setTitle("21 June 2018");


        List<MyGroupContests> contestsList1 = new ArrayList<>();
        contests = new MyGroupContests();
        contests.setName("Early India");
        contests.setCloseEnabled(true);
        contests.setTime("Contest starts in 23 days");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setCloseEnabled(true);
        contests.setName("Capitals Annual Raise");
        contests.setTime("Contest starts in 45 days");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setCloseEnabled(true);
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 1 month");
        contestsList1.add(contests);

        contests = new MyGroupContests();
        contests.setCloseEnabled(true);
        contests.setName("Facebook Quiz");
        contests.setTime("Contest starts in 2 Months");
        contestsList1.add(contests);


        allContest.setMyGroupContestsList(contestsList1);

        allContestList.add(allContest);

        recyclerViewAdapter.clearAndAddNewData(allContestList);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
