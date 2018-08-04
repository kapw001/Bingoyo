package com.bingoyo.customview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bingoyo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EarningsPointView extends LinearLayout {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.points)
    TextView points;

    public EarningsPointView(Context context) {
        super(context);
        initView();
    }

    public EarningsPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public EarningsPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EarningsPointView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {

        View view = inflate(getContext(), R.layout.custom_view_earnings_points, this);

        ButterKnife.bind(this, view);

    }


    public void setTitle(String t) {
        this.title.setText(t);
    }

    public void setImg(int drawable) {

        this.img.setImageResource(drawable);
    }

    public void setPoints(String po) {

        this.points.setText(po);
    }


}
