package com.bingoyo.dashboard.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.dashboard.allcontests.ContestDeatilsActivity;
import com.bingoyo.dashboard.mycontests.MyContestsGroupDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyGroupDetailsActivity extends InitViewBaseActivity {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.invited_profile)
    CircleImageView invitedProfile;
    @BindView(R.id.invited)
    TextView invited;
    @BindView(R.id.deatils)
    LinearLayout deatils;
    @BindView(R.id.play)
    Button play;
    @BindView(R.id.collection_set)
    Button collectionSet;
    @BindView(R.id.remove)
    Button remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_my_group_details);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Team Bridge contest");
    }

    @Override
    protected void intView() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick(R.id.play)
    public void onClick(View view) {

        startActivity(new Intent(this, ContestDeatilsActivity.class));

    }
}
