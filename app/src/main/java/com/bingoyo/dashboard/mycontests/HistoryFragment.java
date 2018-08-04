package com.bingoyo.dashboard.mycontests;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingoyo.R;
import com.bingoyo.base.BaseFragment;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
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
public class HistoryFragment extends BaseFragment {


    @BindView(R.id.historyListView)
    RecyclerView historyListView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView();
        loadHistoryData();

        return view;
    }


    private void initView() {


        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());

        historyListView.setLayoutManager(new LinearLayoutManager(getContext()));

        historyListView.setAdapter(recyclerViewAdapter);


        recyclerViewAdapter.setCallBackValue(new RecyclerViewAdapter.CallBackValue() {
            @Override
            public void onItemClickValue(View view, Object o, int position) {

                Intent intent = new Intent(getContext(), MyContestsHistroyDetailsActivity.class);

                startActivity(intent);

            }
        });

    }


    private void loadHistoryData() {


        List allContestList = new ArrayList<>();

        MyContests allContest = new MyContests();
        allContest.setTitle("Yesterday");


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
        allContest.setTitle("12 Mar 2018");


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
