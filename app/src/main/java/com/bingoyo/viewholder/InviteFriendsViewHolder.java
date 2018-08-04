package com.bingoyo.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.InviteFriends;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InviteFriendsViewHolder extends RelativeLayout implements RecyclerViewRow<InviteFriends> {

    @BindView(R.id.name)
    TextView name;

    public InviteFriendsViewHolder(Context context) {
        super(context);
    }

    public InviteFriendsViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InviteFriendsViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InviteFriendsViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
    public void showData(InviteFriends item) {

        name.setText(item.getName());

        if (item.isSelected()) {
            name.setTextColor(Color.WHITE);
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.loginStartColor));

        } else {
            name.setTextColor(Color.GRAY);
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        }

    }

    @Override
    public void setCallBack(RecyclerViewAdapter.CallBackValue callBack) {

    }

    @Override
    public void setOnItemClickListener(OnClickListener listener) {

        this.setOnClickListener(listener);
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
