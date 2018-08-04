package com.bingoyo.dashboard.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.dashboard.allcontests.ContestDeatilsActivity;
import com.bingoyo.model.MYGroupModels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyGroupActivity extends InitViewBaseActivity {

    //    @BindView(R.id.byinvites)
//    TabItem byinvites;
//    @BindView(R.id.byjoined)
//    TabItem byjoined;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_my_group);
        setButterKnife();
        setBackButtonEnabledAndTitle("My Group");
        intView();
        loadData();


    }

    @Override
    protected void intView() {


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());

        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scrollview).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });


        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                startActivity(new Intent(getApplicationContext(), MyGroupDetailsActivity.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void loadData() {

        List list = new ArrayList();

        MYGroupModels myGroupModels = new MYGroupModels();
        myGroupModels.setmByInvited("Invited by Sara Haroon");
        myGroupModels.setmDescription("dsfsdfsdf");
        myGroupModels.setmDate("21st May 2018");
        myGroupModels.setmTime("10:00 AM");

        list.add(myGroupModels);

        myGroupModels = new MYGroupModels();
        myGroupModels.setmByInvited("Invited by Ben");
        myGroupModels.setmDescription(getResources().getString(R.string.txtdes));
        myGroupModels.setmDate("11st June 2018");
        myGroupModels.setmTime("1:00 PM");

        list.add(myGroupModels);

        myGroupModels = new MYGroupModels();
        myGroupModels.setmByInvited("Invited by Stephen");
        myGroupModels.setmDescription(getResources().getString(R.string.txtdes));
        myGroupModels.setmDate("1st Jan 2018");
        myGroupModels.setmTime("2:00 AM");

        list.add(myGroupModels);

        myGroupModels = new MYGroupModels();
        myGroupModels.setmByInvited("Invited by Haroon");
        myGroupModels.setmDescription(getResources().getString(R.string.txtdes));
        myGroupModels.setmDate("6st May 2018");
        myGroupModels.setmTime("6:00 AM");

        list.add(myGroupModels);

        recyclerViewAdapter.clearAndAddNewData(list);


    }
}
