package com.bingoyo.dashboard.rewards;


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
import com.bingoyo.model.AvailableProduct;
import com.bingoyo.model.Availables;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvailableRewardsFragment extends BaseFragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;

    public AvailableRewardsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_available_rewards, container, false);
        unbinder = ButterKnife.bind(this, view);

        init();

        loadData();

        return view;
    }


    private void init() {

        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(recyclerViewAdapter);

    }


    private void loadData() {


        List list = new ArrayList();

        Availables availables = new Availables();
        availables.setTitle("7 days to expire");

        List<AvailableProduct> list1 = new ArrayList<>();

        AvailableProduct product = new AvailableProduct();
        product.setSname("Mars");
        product.setSname1("Earth");
        product.setSname2("Saturn");

        product.setRewards("2000");
        product.setRewards1("150");
        product.setRewards2("200");

        list1.add(product);

        product = new AvailableProduct();
        product.setImageEnabled(true);
        product.setSname("Gems");
        product.setSname1("Lock");
        product.setSname2("Circket Bats");

        product.setRewards("125");
        product.setRewards1("5");
        product.setRewards2("45");

        list1.add(product);

        availables.setList(list1);

        list.add(availables);


        availables = new Availables();
        availables.setTitle("10 days to expire");

        list1 = new ArrayList<>();

        product = new AvailableProduct();
        product.setSname("Mars");
        product.setSname1("Earth");
        product.setSname2("Satur");

        product.setRewards("2000");
        product.setRewards1("150");
        product.setRewards2("200");

        list1.add(product);

        product = new AvailableProduct();
        product.setImageEnabled(true);
        product.setSname("Gems");
        product.setSname1("Lock");
        product.setSname2("Circket Bats");

        product.setRewards("125");
        product.setRewards1("5");
        product.setRewards2("45");

        list1.add(product);

        availables.setList(list1);

        list.add(availables);

        recyclerViewAdapter.clearAndAddNewData(list);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
