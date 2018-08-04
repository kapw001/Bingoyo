package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

import java.util.List;

public class MyContests implements ViewLayout {

    private String title;
    private List<Contests> list;

    private boolean isMyGroup = false;

    public boolean isMyGroup() {
        return isMyGroup;
    }

    public void setMyGroup(boolean myGroup) {
        isMyGroup = myGroup;
    }

    public List<MyGroupContests> getMyGroupContestsList() {
        return myGroupContestsList;
    }

    public void setMyGroupContestsList(List<MyGroupContests> myGroupContestsList) {
        this.myGroupContestsList = myGroupContestsList;
    }

    private List<MyGroupContests> myGroupContestsList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Contests> getList() {
        return list;
    }

    public void setList(List<Contests> list) {
        this.list = list;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_my_contests;
    }
}
