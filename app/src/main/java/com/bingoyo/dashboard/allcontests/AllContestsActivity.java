package com.bingoyo.dashboard.allcontests;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bingoyo.R;
import com.bingoyo.adapter.AllContestsAdapter;
import com.bingoyo.base.BaseActivity;
import com.bingoyo.model.AllContest;
import com.bingoyo.model.Contests;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllContestsActivity extends BaseActivity {


    @BindView(R.id.topics)
    RadioButton topics;
    @BindView(R.id.upcoming)
    RadioButton upcoming;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.allcontestsListview)
    RecyclerView mAllContestsView;

    private AllContestsAdapter allContestsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            Drawable background = getResources().getDrawable(R.drawable.gradient_login_view);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
            getSupportActionBar().setBackgroundDrawable(background);

//            window.setBackgroundDrawable(background);
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }

        setContentView(R.layout.activity_all_contests);
        setButterKnife();

        setBackButtonEnabledAndTitle("All Contests");


        allContestsAdapter = new AllContestsAdapter(this, new ArrayList<AllContest>());

        mAllContestsView.setLayoutManager(new LinearLayoutManager(this));

        mAllContestsView.setAdapter(allContestsAdapter);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.topics:
                        loadDataTopics();
                        break;

                    case R.id.upcoming:
                        loadDataUpcoming();
                        break;

                }
            }
        });

        loadDataUpcoming();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void loadDataUpcoming() {

        List<AllContest> allContestList = new ArrayList<>();

        AllContest allContest = new AllContest();
        allContest.setTitle("Today");


        List<Contests> contestsList = new ArrayList<>();
        Contests contests = new Contests();
        contests.setName("Modi Facts");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Y Combinator");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Facebook Quiz");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Firebase Test");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Unity Cetificate");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);


        allContest.setList(contestsList);

        allContestList.add(allContest);

        allContest = new AllContest();
        allContest.setTitle("Tomorrow");


        List<Contests> contestsList1 = new ArrayList<>();
        contests = new Contests();
        contests.setName("Modi Facts");
        contests.setTime("1 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Talent Bridge Contest");
        contests.setTime("1 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Y Combinator");
        contests.setTime("1 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Facebook Quiz");
        contests.setTime("1 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Firebase Test");
        contests.setTime("1 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Unity Cetificate");
        contests.setTime("1 days");
        contestsList1.add(contests);


        allContest.setList(contestsList1);

        allContestList.add(allContest);

//        allContest = new AllContest();
//        allContest.setTitle("21 December");
//        allContest.setList(new ArrayList<Contests>());
//
//        allContestList.add(allContest);
        allContestsAdapter.updateList(allContestList);
    }


    private void loadDataTopics() {

        List<AllContest> allContestList = new ArrayList<>();

        AllContest allContest = new AllContest();
        allContest.setTitle("Food");


        List<Contests> contestsList = new ArrayList<>();
        Contests contests = new Contests();
        contests.setName("Punjabi Tangy");
        contests.setTime("in 20 Mins");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Foody Goody");
        contests.setTime("in 2 Hours");
        contestsList.add(contests);

        contests = new Contests();
        contests.setName("Guntur Gongur");
        contests.setTime("in 1 hour");
        contestsList.add(contests);

        allContest.setList(contestsList);

        allContestList.add(allContest);

        allContest = new AllContest();
        allContest.setTitle("Architecture");


        List<Contests> contestsList1 = new ArrayList<>();
        contests = new Contests();
        contests.setName("Popular Buildings");
        contests.setTime("2 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Buildings Measurement");
        contests.setTime("1 days");
        contestsList1.add(contests);

        contests = new Contests();
        contests.setName("Stair Types");
        contests.setTime("5 days");
        contestsList1.add(contests);

//        contests = new Contests();
//        contests.setName("Facebook Quiz");
//        contests.setTime("10 days");
//        contestsList1.add(contests);
//
//        contests = new Contests();
//        contests.setName("Firebase Test");
//        contests.setTime("in 20 Mins");
//        contestsList1.add(contests);
//
//        contests = new Contests();
//        contests.setName("Unity Cetificate");
//        contests.setTime("in 20 Mins");
//        contestsList1.add(contests);


        allContest.setList(contestsList1);

        allContestList.add(allContest);

//        allContest = new AllContest();
//        allContest.setTitle("21 December");
//        allContest.setList(new ArrayList<Contests>());
//
//        allContestList.add(allContest);
        allContestsAdapter.updateList(allContestList);
    }


}
