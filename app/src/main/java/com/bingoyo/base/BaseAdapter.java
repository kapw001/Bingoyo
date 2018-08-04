package com.bingoyo.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> list;

    protected OnItemClick<T> onItemClick;

    protected BaseAdapter(List<T> list) {
        this.list = list;
    }

    protected BaseAdapter(OnItemClick<T> onItemClick,List<T> list) {
        this.onItemClick=onItemClick;
        this.list = list;
    }

    public List<T> getList(){

        return list;
    }

    public void updateList(List<T> tList){
        this.list=new ArrayList<>();
        this.list=tList;
        notifyDataSetChanged();
    }

    protected T getValue(int pos){

        return list.get(pos);
    }

    protected int getCount(){

        return list.size();
    }

    protected void setText(TextView textView,String s){

        textView.setText(s);
    }


    public interface OnItemClick<T>{

        void OnItemClickListener(View view, T t, int postition);

    }

}
