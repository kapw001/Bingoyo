package com.bingoyo.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class VH<T> extends RecyclerView.ViewHolder {

    public VH(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

    }
//
//    public abstract void bind(T t);
//
//    public abstract void unbind(T t);
}
