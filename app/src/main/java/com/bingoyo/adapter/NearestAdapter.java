package com.bingoyo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.BaseAdapter;
import com.bingoyo.base.VH;
import com.bingoyo.model.States;

import java.util.List;

import butterknife.BindView;

public class NearestAdapter extends BaseAdapter<States, NearestAdapter.NearestVH> {


    private int selectedPosition = -1;

    private Context mContext;

    public NearestAdapter(Context mContext, List<States> list) {
        super(list);
        this.mContext = mContext;
    }


//    protected NearestAdapter(List<Downloads.Datum> list) {
//        super(list);
//    }

    @NonNull
    @Override
    public NearestVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_local_state, parent, false);

        return new NearestVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NearestVH holder, final int position) {

        final States datum = getValue(position);

        setText(holder.mTitle, datum.getStateName());

        if (selectedPosition==position) {

            holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext,android.R.color.holo_orange_light));
            holder.mTitle.setTextColor(Color.WHITE);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
            holder.mTitle.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedPosition = position;

                notifyDataSetChanged();

            }
        });

    }


    @Override
    public int getItemCount() {
        return getCount();
    }

    protected class NearestVH extends VH {

        @BindView(R.id.state_name)
        TextView mTitle;


        public NearestVH(View itemView) {
            super(itemView);
        }

    }
}
