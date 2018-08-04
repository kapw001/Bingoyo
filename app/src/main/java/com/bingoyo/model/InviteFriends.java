package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

public class InviteFriends implements ViewLayout {


    private String name;

    private boolean isSelected = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_invite_friends;
    }
}
