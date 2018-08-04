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
import com.bingoyo.model.RedeemedProduct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedeemedRewardFragment extends BaseFragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    private RecyclerViewAdapter recyclerViewAdapter;

    public RedeemedRewardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_redeemed_reward, container, false);
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
        availables.setTitle("21st October");
        availables.setRedeemed(true);
        List<RedeemedProduct> list1 = new ArrayList<>();

        RedeemedProduct product = new RedeemedProduct();
        product.setPrice_aviled("Amazon Rs. 500 is availed");


        list1.add(product);

        product = new RedeemedProduct();
        product.setPrice_aviled("Amazon Rs. 3000 is availed");
        list1.add(product);

        availables.setRedeemedProductList(list1);

        list.add(availables);


        availables = new Availables();
        availables.setTitle("31st November");
        availables.setRedeemed(true);

        list1 = new ArrayList<>();

        product = new RedeemedProduct();
        product.setPrice_aviled("Amazon Rs. 1500 is availed");

        list1.add(product);


        list1.add(product);

        availables.setRedeemedProductList(list1);

        list.add(availables);

        recyclerViewAdapter.clearAndAddNewData(list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
