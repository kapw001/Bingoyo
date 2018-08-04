package com.bingoyo.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.Rank;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RankViewHolder extends LinearLayout implements RecyclerViewRow<Rank> {

    @BindView(R.id.rank)
    TextView rank;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.points)
    TextView points;

    public RankViewHolder(Context context) {
        super(context);
    }

    public RankViewHolder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RankViewHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RankViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);
    }

    @Override
    public View getForeGroundView() {
        return this;
    }

    @Override
    public void showData(Rank item) {

        if (!item.isHeader()) {


            rank.setText(item.getPosition() + "");
            name.setText(item.getName());
            points.setText(item.getPoints());


            rank.setTextColor(Color.GRAY);
            name.setTextColor(Color.GRAY);
            points.setTextColor(Color.GRAY);

        }


        if (item.isThere()) {

            rank.setTextColor(Color.WHITE);
            name.setTextColor(Color.WHITE);
            points.setTextColor(Color.WHITE);
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.loginStartColor));

        } else {
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        }


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
