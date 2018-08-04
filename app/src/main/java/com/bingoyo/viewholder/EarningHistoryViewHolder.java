package com.bingoyo.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.EarningsPoints;

import github.nisrulz.stackedhorizontalprogressbar.StackedHorizontalProgressBar;

public class EarningHistoryViewHolder extends LinearLayout implements RecyclerViewRow<EarningsPoints> {

    private TextView title, points;
    private StackedHorizontalProgressBar bar;

    public EarningHistoryViewHolder(Context context) {
        super(context);
    }

    public EarningHistoryViewHolder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EarningHistoryViewHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EarningHistoryViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        title = (TextView) findViewById(R.id.title);
        points = (TextView) findViewById(R.id.points);
        bar = (StackedHorizontalProgressBar) findViewById(R.id.stackedhorizontalprogressbar);
    }

    @Override
    public View getForeGroundView() {
        return this;
    }


    @Override
    public void showData(EarningsPoints item) {

        title.setText(item.getTitle());

        points.setText(item.getPoints() + "");

        int points = item.getPoints();
        bar.setMax(100);
        bar.setProgress(points);


    }

    @Override
    public void setCallBack(RecyclerViewAdapter.CallBackValue callBack) {

    }

    @Override
    public void setOnItemClickListener(OnClickListener listener) {

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
