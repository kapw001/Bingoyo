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
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bingoyo.R;
import com.bingoyo.commonadapter.RecyclerViewAdapter;
import com.bingoyo.commonadapter.RecyclerViewRow;
import com.bingoyo.model.MyContests;

import java.util.ArrayList;

public class MyContestViewHolder extends RelativeLayout implements RecyclerViewRow<MyContests> {

    private static final String TAG = "MyContestViewHolder";
    private TextView title;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public MyContestViewHolder(Context context) {
        super(context);
    }

    public MyContestViewHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyContestViewHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyContestViewHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        title = (TextView) findViewById(R.id.title);
        recyclerView = (RecyclerView) findViewById(R.id.contestsView);

        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {

                Log.e(TAG, "onItemClick: " + recyclerViewAdapter.getCallBackValue());

                if (callBackValue != null)
                    callBackValue.onItemClickValue(view, o, position);
            }
        });


    }

    @Override
    public View getForeGroundView() {
        return this;
    }

    @Override
    public void showData(MyContests item) {

        title.setText(item.getTitle() + "");


        if (item.isMyGroup()) {

            recyclerViewAdapter.clearAndAddNewData(item.getMyGroupContestsList());

        } else {

            recyclerViewAdapter.clearAndAddNewData(item.getList());
        }

    }

    private RecyclerViewAdapter.CallBackValue callBackValue;

    @Override
    public void setCallBack(RecyclerViewAdapter.CallBackValue callBack) {
        this.callBackValue = callBack;
    }

    private OnClickListener onClickListener;

    @Override
    public void setOnItemClickListener(OnClickListener listener) {

        this.onClickListener = listener;

        setOnClickListener(listener);
    }

    @Override
    public void setOnItemClickListener(RecyclerViewAdapter.OnRecyclerViewItemClickListener listener) {

        if (recyclerViewAdapter != null) {

            recyclerViewAdapter.setOnItemClickListener(listener);
        }
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
