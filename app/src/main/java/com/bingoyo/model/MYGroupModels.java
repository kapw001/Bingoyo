package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

public class MYGroupModels implements ViewLayout{

    private String mByInvited;

    private String mDescription;

    private String mDate;

    private String mTime;

    public String getmByInvited() {
        return mByInvited;
    }

    public void setmByInvited(String mByInvited) {
        this.mByInvited = mByInvited;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_my_group_view;
    }
}
