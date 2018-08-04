package com.bingoyo.dashboard.invitefriends;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.model.InviteFriends;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InvitesFriendsActivity extends InitViewBaseActivity {

    @BindView(R.id.selectAll)
    TextView selectAll;
    @BindView(R.id.invite)
    TextView invite;
    @BindView(R.id.invitesView)
    RecyclerView invitesView;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_invites_friends);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Invite Friends");

        intView();

        loadData();
    }

    @Override
    protected void intView() {
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());
        invitesView.setLayoutManager(new LinearLayoutManager(this));

        invitesView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener<InviteFriends>() {
            @Override
            public void onItemClick(View view, InviteFriends inviteFriends, int position) {

                inviteFriends.setSelected(!inviteFriends.isSelected());

                recyclerViewAdapter.notifyItemChanged(position);
            }
        });

    }

    private void loadData() {

        List list = new ArrayList();

        InviteFriends inviteFriends = new InviteFriends();

        inviteFriends.setName("Ben");
        list.add(inviteFriends);

        inviteFriends = new InviteFriends();

        inviteFriends.setName("Varun");
        list.add(inviteFriends);

        inviteFriends = new InviteFriends();

        inviteFriends.setName("Haroon");
        list.add(inviteFriends);

        inviteFriends = new InviteFriends();

        inviteFriends.setName("Sachin");
        list.add(inviteFriends);

        inviteFriends = new InviteFriends();

        inviteFriends.setName("Saara");
        list.add(inviteFriends);

        recyclerViewAdapter.clearAndAddNewData(list);

    }


    @OnClick({R.id.selectAll, R.id.invite})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.selectAll:


                List<InviteFriends> friendsList = recyclerViewAdapter.getmDataset();

                for (int i = 0; i < friendsList.size(); i++) {

                    friendsList.get(i).setSelected(true);

                }

                recyclerViewAdapter.notifyDataSetChanged();

                break;

            case R.id.invite:

                showToast("Invite");

                break;


        }

    }
}
