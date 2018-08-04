package com.bingoyo.dashboard.leaderboard;


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
import com.bingoyo.model.Rank;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicFragment extends BaseFragment {


    @BindView(R.id.leaderboardView)
    RecyclerView leaderboardView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;


    public PublicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_public, container, false);
        unbinder = ButterKnife.bind(this, view);

        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());

        leaderboardView.setLayoutManager(new LinearLayoutManager(getContext()));
        leaderboardView.setAdapter(recyclerViewAdapter);
        loadData();

        return view;
    }


    public void loadData() {

        List list = new ArrayList();

        Rank rank = new Rank();
        rank.setHeader(true);
        list.add(rank);

        rank = new Rank();
        rank.setName("Varun Aran");
        rank.setPoints("26000");
        rank.setPosition(1);
        list.add(rank);

        rank = new Rank();
        rank.setName("Ponting Dubey");
        rank.setPoints("22000");
        rank.setPosition(2);
        list.add(rank);

        rank = new Rank();
        rank.setName("Vardhama Parekh");
        rank.setPoints("18000");
        rank.setPosition(3);
        list.add(rank);

        rank = new Rank();
        rank.setName("Ben");
        rank.setPoints("16000");
        rank.setPosition(4);
        rank.setThere(true);
        list.add(rank);

        rank = new Rank();
        rank.setName("Simon");
        rank.setPoints("400");
        rank.setPosition(5);
        list.add(rank);

        recyclerViewAdapter.clearAndAddNewData(list);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
