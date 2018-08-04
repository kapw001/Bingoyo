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
import android.widget.Switch;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.BlockFriends;
import com.bingoyo.model.InviteFriends;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlockFriendsViewHolder extends RelativeLayout implements RecyclerViewRow<BlockFriends> {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.blockSwitch)
    Switch blockfriends;

    public BlockFriendsViewHolder(Context context) {
        super(context);
    }

    public BlockFriendsViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlockFriendsViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BlockFriendsViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
    public void showData(BlockFriends item) {

        name.setText(item.getName());

        blockfriends.setChecked(item.isBlocked());

        blockfriends.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

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

        blockfriends.setOnCheckedChangeListener(onChangeListener);

    }

    @Override
    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {

    }
}
