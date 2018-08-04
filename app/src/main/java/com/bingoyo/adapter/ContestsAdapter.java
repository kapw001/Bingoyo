package com.bingoyo.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.BaseAdapter;
import com.bingoyo.base.VH;
import com.bingoyo.dashboard.allcontests.AllContestsDetailsActivity;
import com.bingoyo.model.AllContest;
import com.bingoyo.model.Contests;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContestsAdapter extends BaseAdapter<Contests, ContestsAdapter.AllContestsVH> {


    private int selectedPosition = -1;

    private Context mContext;

    public ContestsAdapter(Context mContext, List<Contests> list) {
        super(list);
        this.mContext = mContext;
    }


//    protected NearestAdapter(List<Downloads.Datum> list) {
//        super(list);
//    }

    @NonNull
    @Override
    public AllContestsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_contests, parent, false);

        return new AllContestsVH(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final AllContestsVH holder, final int position) {

        holder.img.setClipToOutline(true);

        final Contests contests = getValue(position);

        holder.name.setText(contests.getName());
        holder.time.setText(contests.getTime());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(), AllContestsDetailsActivity.class);

                intent.putExtra("contest", contests);
                v.getContext().startActivity(intent);

            }
        });

//        if (position % 2 == 0) {
//
//            holder.name.setText("dddd");
//        }


    }


    @Override
    public int getItemCount() {
        return getCount();
    }

    protected class AllContestsVH extends VH {
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;

        public AllContestsVH(View itemView) {
            super(itemView);
        }

    }

}
