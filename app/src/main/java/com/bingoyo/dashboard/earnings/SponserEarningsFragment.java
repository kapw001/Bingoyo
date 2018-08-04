package com.bingoyo.dashboard.earnings;


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
import com.bingoyo.model.EarningsPoints;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SponserEarningsFragment extends EarningBaseFragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;

    public SponserEarningsFragment() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getView() != null) {
            if (viewChangeCallBack != null) viewChangeCallBack.onSponzerCallBack();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponser_earnings, container, false);
        unbinder = ButterKnife.bind(this, view);

        if (getUserVisibleHint()) {
            if (viewChangeCallBack != null) viewChangeCallBack.onSponzerCallBack();
        }
        initView();
        loadData();
        return view;
    }


    private void initView() {


        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(recyclerViewAdapter);


    }

    private void loadData() {


        List<EarningsPoints> list = new ArrayList<>();

        EarningsPoints points = new EarningsPoints();

        points.setTitle("Sun");
        points.setPoints(10);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Moon");
        points.setPoints(50);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Mercury");
        points.setPoints(60);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Mars");
        points.setPoints(70);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Jupiter");
        points.setPoints(80);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Saturn");
        points.setPoints(40);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Neptune");
        points.setPoints(30);

        list.add(points);

        points = new EarningsPoints();

        points.setTitle("Cir Bat");
        points.setPoints(20);

        list.add(points);


        recyclerViewAdapter.clearAndAddNewData(list);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
