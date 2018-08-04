package com.bingoyo.viewholder;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.customview.MaxHeightScrollView;
import com.bingoyo.model.MYGroupModels;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyGroupViewHolder extends RelativeLayout implements RecyclerViewRow<MYGroupModels> {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.profile)
    CircleImageView profile;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.more_info)
    Button moreInfo;
    @BindView(R.id.close)
    ImageView close;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.mdate)
    TextView mdate;
    @BindView(R.id.mtime)
    TextView mtime;
    @BindView(R.id.scrollview)
    MaxHeightScrollView scrollview;

    public MyGroupViewHolder(Context context) {
        super(context);
    }

    public MyGroupViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroupViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyGroupViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//        View view = inflate(getContext(), R.layout.row_item_my_group_view, this);
        ButterKnife.bind(this, this);

//        inflate(getContext(), R.layout.row_item_my_group_view, this);
    }

    @Override
    public View getForeGroundView() {
        return this;
    }

    @Override
    public void showData(MYGroupModels item) {


        name.setText(item.getmByInvited());

        description.setText(item.getmDescription());

        mdate.setText(item.getmDate());
        mtime.setText(item.getmTime());
        scrollview.setNestedScrollingEnabled(true);
        scrollview.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
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
