package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

public class AvailableProduct implements ViewLayout {

    private String sname,sname1,sname2;
    private String rewards,rewards1,rewards2;

    private boolean isImageEnabled=false;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSname1() {
        return sname1;
    }

    public void setSname1(String sname1) {
        this.sname1 = sname1;
    }

    public String getSname2() {
        return sname2;
    }

    public void setSname2(String sname2) {
        this.sname2 = sname2;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getRewards1() {
        return rewards1;
    }

    public void setRewards1(String rewards1) {
        this.rewards1 = rewards1;
    }

    public String getRewards2() {
        return rewards2;
    }

    public void setRewards2(String rewards2) {
        this.rewards2 = rewards2;
    }

    public boolean isImageEnabled() {
        return isImageEnabled;
    }

    public void setImageEnabled(boolean imageEnabled) {
        isImageEnabled = imageEnabled;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_available_rewards;
    }
}
