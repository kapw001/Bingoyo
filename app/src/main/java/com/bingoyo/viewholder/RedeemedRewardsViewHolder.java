package com.bingoyo.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import com.bingoyo.model.AvailableProduct;
import com.bingoyo.model.RedeemedProduct;

public class RedeemedRewardsViewHolder extends RelativeLayout implements RecyclerViewRow<RedeemedProduct> {

    private static final String TAG = "MyContestViewHolder";

    private TextView price_availed;


    public RedeemedRewardsViewHolder(Context context) {
        super(context);
    }

    public RedeemedRewardsViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RedeemedRewardsViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RedeemedRewardsViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        price_availed = (TextView) findViewById(R.id.price_availed);

    }

    @Override
    public View getForeGroundView() {
        return this;
    }

    @Override
    public void showData(RedeemedProduct item) {

        price_availed.setText(item.getPrice_aviled());

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
