package com.bingoyo.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.AvailableProduct;
import com.bingoyo.model.MyContests;

import java.util.ArrayList;

public class AvailableRewardsViewHolder extends RelativeLayout implements RecyclerViewRow<AvailableProduct> {

    private static final String TAG = "MyContestViewHolder";

    private TextView name, name1, name2;
    private ImageView img, img1, img2;
    private TextView sname, sname1, sname2;
    private TextView rewards, rewards1, rewards2;


    public AvailableRewardsViewHolder(Context context) {
        super(context);
    }

    public AvailableRewardsViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AvailableRewardsViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AvailableRewardsViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        name = (TextView) findViewById(R.id.name);
        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);

        sname = (TextView) findViewById(R.id.sname);
        sname1 = (TextView) findViewById(R.id.sname1);
        sname2 = (TextView) findViewById(R.id.sname2);

        rewards = (TextView) findViewById(R.id.rewards);
        rewards1 = (TextView) findViewById(R.id.rewards1);
        rewards2 = (TextView) findViewById(R.id.rewards2);

        img = (ImageView) findViewById(R.id.img);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);

    }

    @Override
    public View getForeGroundView() {
        return this;
    }

    @Override
    public void showData(AvailableProduct item) {


        sname.setText(item.getSname());
        sname1.setText(item.getSname1());
        sname2.setText(item.getSname2());

        rewards.setText(item.getRewards());
        rewards1.setText(item.getRewards1());
        rewards2.setText(item.getRewards2());

        String s = String.valueOf(item.getSname().charAt(0));

        name.setText(s.toUpperCase());
        name1.setText(String.valueOf(item.getSname1().charAt(0)).toUpperCase());
        name2.setText(String.valueOf(item.getSname2().charAt(0)).toUpperCase());

        if (item.isImageEnabled()) {

            name.setVisibility(GONE);
            name1.setVisibility(GONE);
            name2.setVisibility(GONE);

            img.setVisibility(VISIBLE);
            img1.setVisibility(VISIBLE);
            img2.setVisibility(VISIBLE);
        }

    }


    @Override
    public void setCallBack(RecyclerViewAdapter.CallBackValue callBack) {

    }


    @Override
    public void setOnItemClickListener(OnClickListener listener) {


        setOnClickListener(listener);
    }

    @Override
    public void setOnItemClickListener(RecyclerViewAdapter.OnRecyclerViewItemClickListener listener) {


    }

    @Override
    public void setOnItemLongClickListener(OnLongClickListener listener) {

    }

    @Override
    public void setOnChangeListener(CompoundButton.OnCheckedChangeListener onChangeListener) {

    }

    @Override
    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {

    }
}
