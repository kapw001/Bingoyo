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
import com.bingoyo.model.AllContest;
import com.bingoyo.model.Contests;
import com.bingoyo.model.MyContests;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentFragment extends BaseFragment {

    private static final String TAG = "CurrentFragment";
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.myContestsListView)
    RecyclerView myContestsListView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;

    public CurrentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }


    private void initView() {

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                if (tab.getPosition() == 0) {
                    loadDataByDate();
                } else {
                    loadDataByTopic();
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


        recyclerViewAdapter.setCallBackValue(new RecyclerViewAdapter.CallBackValue<Contests>() {
            @Override
            public void onItemClickValue(View view, Contests o, int position) {
//                Log.e(TAG, "onItemClick: " + position + "   " + o.toString());


                Intent intent = new Intent(getContext(), MyContestsDetailsActivity.class);

                startActivity(intent);


            }
        });

        loadDataByDate();

    }


    private void loadDataByDate() {


        List allContestList = new ArrayList<>();

        MyContests allContest = new MyContests();
        allContest.setTitle("Today");


        List contestsList = new ArrayList<>();
        Contests contests = new Contests();
        contests.setName("Modi Facts");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Facebook Quiz");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Firebase Test");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Unity Cetificate");
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);


        allContest.setList(contestsList);

        allContestList.add(allContest);

        allContest = new MyContests();
        allContest.setTitle("Tomorrow");


        List<Contests> contestsList1 = new ArrayList<>();
        contests = new Contests();
        contests.setName("Modi Facts");
        contests.setTime("Contest starts in 2 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("Contest starts in 5 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 1 month");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Facebook Quiz");
        contests.setTime("Contest starts in 10 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Firebase Test");
        contests.setTime("Contest starts in 20 Mins");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Unity Cetificate");
        contests.setTime("Contest starts in 20 Mins");
        contestsList1.add(contests);

        allContest.setList(contestsList1);

        allContestList.add(allContest);

        recyclerViewAdapter.clearAndAddNewData(allContestList);

    }


    private void loadDataByTopic() {


        List allContestList = new ArrayList<>();

        MyContests allContest = new MyContests();
        allContest.setTitle("Politics");


        List contestsList = new ArrayList<>();
        Contests contests = new Contests();
        contests.setName("Modi Facts");
        contests.setCloseEnabled(true);
        contests.setTime("Contest starts in 20 Minutes");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("Contest starts in 20 Minutes");
        contests.setCloseEnabled(true);
        contestsList.add(contests);

        contests = new Contests();
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


        allContest.setList(contestsList);

        allContestList.add(allContest);

        allContest = new MyContests();
        allContest.setTitle("History");


        List<Contests> contestsList1 = new ArrayList<>();
        contests = new Contests();
        contests.setName("Early India");
        contests.setCloseEnabled(true);
        contests.setTime("Contest starts in 23 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setCloseEnabled(true);
        contests.setName("Capitals Annual Raise");
        contests.setTime("Contest starts in 45 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setCloseEnabled(true);
        contests.setName("Y Combinator");
        contests.setTime("Contest starts in 1 month");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setCloseEnabled(true);
        contests.setName("Facebook Quiz");
        contests.setTime("Contest starts in 2 Months");
        contestsList1.add(contests);


        allContest.setList(contestsList1);

        allContestList.add(allContest);

        recyclerViewAdapter.clearAndAddNewData(allContestList);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
