package com.bingoyo.dashboard.allcontests;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class ContestBeginPageActivity extends BaseActivity {

    @BindView(R.id.skip)
    Button skip;
    @BindView(R.id.request_callback)
    Button requestCallback;
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard videoplayer;

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
        setContentView(R.layout.activity_contest_begin_page);
        ButterKnife.bind(this);

        setButterKnife();
        setBackButtonEnabledAndTitle("Team Bridge contest");


        videoplayer.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4",
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
                "");
//        videoplayer.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");

        videoplayer.thumbImageView.setImageResource(R.drawable.profile);
        videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @OnClick(R.id.request_callback)
    public void onClick(View view) {


        RequestCallBackFragment requestCallBackFragment = new RequestCallBackFragment();

        requestCallBackFragment.show(getSupportFragmentManager(), "Request_Call_Back");


    }
}
