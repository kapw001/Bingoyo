package com.bingoyo.shownearestcountry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.bingoyo.R;
import com.bingoyo.adapter.NearestAdapter;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.dashboard.home.HomeActivity;
import com.bingoyo.model.Country;
import com.bingoyo.model.States;
import com.bingoyo.utility.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NearestCountryActivity extends BaseActivity {


    @BindView(R.id.country)
    Spinner countrySpinner;
    @BindView(R.id.statesListView)
    RecyclerView statesListView;
    @BindView(R.id.select_zone)
    Button selectZone;

    private NearestAdapter nearestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_country);
        ButterKnife.bind(this);
        initViews();
        getCountryANdStates();
    }


    private void initViews() {

        nearestAdapter = new NearestAdapter(this, new ArrayList<States>());

        statesListView.setLayoutManager(new LinearLayoutManager(this));

        statesListView.setAdapter(nearestAdapter);

    }


    @OnClick(R.id.select_zone)
    public void onClick(View v) {

        startActivity(new Intent(this, HomeActivity.class));

    }


    private void getCountryANdStates() {


        String countryStateJson = Utils.loadJSONFromAsset(this, "cities.json");


//        List<States> statesList=new ArrayList<>();
//
//        try {
//            JSONObject jsonObject=new JSONObject(countryStateJson);
//
//            JSONArray jsonArray=jsonObject.getJSONArray("citis");
//
//            for (int i = 0; i <jsonArray.length() ; i++) {
//
//                JSONObject jsonObject1=jsonArray.getJSONObject(i);
//
//                States states=new States(jsonObject1.getString("name"));
//
//                statesList.add(states);
//
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        List<String> countryNameList = new ArrayList<>();
        final List<Country> countryList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(countryStateJson);

            Iterator<?> keyIterate = jsonObject.keys();

            while (keyIterate.hasNext()) {

                String key = (String) keyIterate.next();

                JSONArray jsonArray = jsonObject.getJSONArray(key);
                List<States> statesList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                    States states=new States(jsonObject1.getString("name"));

                    statesList.add(states);

//                    statesList.add(states);

                }

                Country country = new Country();
                countryNameList.add(key);
                country.setCountryName(key);
                country.setStatesList(statesList);

                countryList.add(country);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
////
////        Country country = countryList.get(0);
//
//        nearestAdapter.updateList(statesList);


//        List<States> statesList = new ArrayList<>();
//
//        States states = new States("Test");
//        statesList.add(states);
//        States states1 = new States("Testdxvvsd");
//        statesList.add(states1);

//
        final ArrayAdapter<Country> dataAdapter = new ArrayAdapter<Country>(this, R.layout.row_spinner_item, countryList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.row_spinner_dropdown_item);

        countrySpinner.setAdapter(dataAdapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Country country = dataAdapter.getItem(position);

                if (country.getStatesList() != null && country.getStatesList().size() > 0)
                    nearestAdapter.updateList(country.getStatesList());
                else showToast("There is no states");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
