package com.bingoyo.dashboard.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.bingoyo.R;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.dashboard.blockinvites.BlockFriendsActivity;
import com.bingoyo.dashboard.editprofile.EditProfile;
import com.bingoyo.dashboard.invitefriends.InvitesFriendsActivity;
import com.bingoyo.savepassword.SavePasswordActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends InitViewBaseActivity {

    @BindView(R.id.soundSwitch)
    Switch soundSwitch;
    @BindView(R.id.game_music)
    Switch gameMusic;
    @BindView(R.id.vibration)
    Switch vibration;
    @BindView(R.id.push_notification)
    Switch pushNotification;
    @BindView(R.id.edit_profile)
    RelativeLayout editProfile;
    @BindView(R.id.blocking)
    RelativeLayout blocking;
    @BindView(R.id.change_password)
    RelativeLayout changePassword;
    @BindView(R.id.setdefault_game_zone)
    RelativeLayout setdefaultGameZone;
    @BindView(R.id.favorite_topics)
    RelativeLayout favoriteTopics;
    @BindView(R.id.invite_friends)
    RelativeLayout inviteFriends;
    @BindView(R.id.messages)
    RelativeLayout messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Settings");
    }

    @Override
    protected void intView() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @OnClick({R.id.change_password,R.id.blocking,R.id.invite_friends,R.id.edit_profile})
    public void onClick(View v){

        switch (v.getId()){


            case R.id.change_password:

                startActivity(new Intent(this, SavePasswordActivity.class));

                break;

            case R.id.blocking:

                startActivity(new Intent(this, BlockFriendsActivity.class));

                break;

            case R.id.invite_friends:

                startActivity(new Intent(this, InvitesFriendsActivity.class));

                break;

            case R.id.edit_profile:

                startActivity(new Intent(this, EditProfile.class));

                break;


        }


    }
}
