package com.bingoyo.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.Contests;
import com.bingoyo.model.MyContests;

public class MyContestRowViewHolder extends RelativeLayout implements RecyclerViewRow<Contests> {

    private TextView name, time;
    private ImageView profile, close;

    public MyContestRowViewHolder(Context context) {
        super(context);
    }

    public MyContestRowViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyContestRowViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyContestRowViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        name = (TextView) findViewById(R.id.name);
        time = (TextView) findViewById(R.id.time);
        profile = (ImageView) findViewById(R.id.profile);
        close = (ImageView) findViewById(R.id.close);
        profile.setClipToOutline(true);
    }

    @Override
    public View getForeGroundView() {
        return null;
    }

    @Override
    public void showData(Contests item) {


        name.setText(item.getName());
        time.setText(item.getTime());

        if (item.isCloseEnabled()) {
            close.setVisibility(GONE);
        } else {
            close.setVisibility(VISIBLE);
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
