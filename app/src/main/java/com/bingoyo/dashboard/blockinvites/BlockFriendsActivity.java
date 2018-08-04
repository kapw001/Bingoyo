package com.bingoyo.dashboard.blockinvites;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.model.BlockFriends;
import com.bingoyo.model.InviteFriends;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlockFriendsActivity extends InitViewBaseActivity {


    private static final String TAG = "BlockFriendsActivity";

    @BindView(R.id.selectAll)
    TextView selectAll;
    @BindView(R.id.blockedView)
    RecyclerView blockedView;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_block_friends);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Block Invites");

        intView();
        loadData();
    }

    @Override
    protected void intView() {
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());
        blockedView.setLayoutManager(new LinearLayoutManager(this));

        blockedView.setAdapter(recyclerViewAdapter);


        recyclerViewAdapter.setOnChangeLongClickListener(new RecyclerViewAdapter.OnRecyclerViewCheckBoxChangeClickListener<BlockFriends>() {
            @Override
            public void onChangeListener(View view, int position, BlockFriends o, boolean isChecked) {

                o.setBlocked(!o.isBlocked());

//                recyclerViewAdapter.getmDataset().set(position, inviteFriends);

                recyclerViewAdapter.notifyItemChanged(position);


//                Log.e(TAG, "onItemClick: " + new Gson().toJson(recyclerViewAdapter.getmDataset()));


            }
        });


        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener<BlockFriends>() {
            @Override
            public void onItemClick(View view, BlockFriends inviteFriends, int position) {

                inviteFriends.setBlocked(!inviteFriends.isBlocked());

//                recyclerViewAdapter.getmDataset().set(position, inviteFriends);

                recyclerViewAdapter.notifyItemChanged(position);


//                Log.e(TAG, "onItemClick: " + new Gson().toJson(recyclerViewAdapter.getmDataset()));


            }
        });
    }


    private void loadData() {

        List list = new ArrayList();

        BlockFriends inviteFriends = new BlockFriends();

        inviteFriends.setName("Ben");
        list.add(inviteFriends);

        inviteFriends = new BlockFriends();

        inviteFriends.setName("Varun");
        list.add(inviteFriends);

        inviteFriends = new BlockFriends();

        inviteFriends.setName("Haroon");
        list.add(inviteFriends);

        inviteFriends = new BlockFriends();

        inviteFriends.setName("Sachin");
        list.add(inviteFriends);

        inviteFriends = new BlockFriends();

        inviteFriends.setName("Saara");
        list.add(inviteFriends);

        recyclerViewAdapter.clearAndAddNewData(list);

    }


    @OnClick({R.id.selectAll})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.selectAll:


                List<BlockFriends> friendsList = recyclerViewAdapter.getmDataset();

                for (int i = 0; i < friendsList.size(); i++) {

                    friendsList.get(i).setBlocked(true);

                }

                recyclerViewAdapter.notifyDataSetChanged();

                break;


        }

    }
}
