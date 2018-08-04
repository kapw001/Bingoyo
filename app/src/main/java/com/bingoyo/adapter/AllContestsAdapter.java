package com.bingoyo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.BaseAdapter;
import com.bingoyo.base.VH;
import com.bingoyo.model.AllContest;
import com.bingoyo.model.Contests;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllContestsAdapter extends BaseAdapter<AllContest, AllContestsAdapter.AllContestsVH> {


    private int selectedPosition = -1;

    private Context mContext;

    public AllContestsAdapter(Context mContext, List<AllContest> list) {
        super(list);
        this.mContext = mContext;
    }


//    protected NearestAdapter(List<Downloads.Datum> list) {
//        super(list);
//    }

    @NonNull
    @Override
    public AllContestsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_all_contests, parent, false);

        return new AllContestsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AllContestsVH holder, final int position) {

        final AllContest datum = getValue(position);

        holder.title.setText(datum.getTitle());

        holder.contestsAdapter.updateList(datum.getList());

    }


    @Override
    public int getItemCount() {
        return getCount();
    }

    protected class AllContestsVH<T> extends VH {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.contestsView)
        RecyclerView contestsView;
        private ContestsAdapter contestsAdapter;


        public AllContestsVH(View itemView) {
            super(itemView);

            contestsAdapter = new ContestsAdapter(itemView.getContext(), new ArrayList<Contests>());

            contestsView.setLayoutManager(new GridLayoutManager(itemView.getContext(), 3));

            contestsView.setAdapter(contestsAdapter);
        }

    }

}
