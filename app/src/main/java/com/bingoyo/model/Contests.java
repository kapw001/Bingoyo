package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

import java.io.Serializable;

public class Contests implements ViewLayout,Serializable {

    private String name;
    private String url;
    private String time;

    private boolean isCloseEnabled = false;

    public boolean isCloseEnabled() {
        return isCloseEnabled;
    }

    public void setCloseEnabled(boolean closeEnabled) {
        isCloseEnabled = closeEnabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Contests{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_my_contests_view;
    }
}
