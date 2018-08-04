package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

public class Rank implements ViewLayout {

    private int position;
    private String name;
    private String points;
    private boolean isThere = false;

    private boolean isHeader = false;

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isThere() {
        return isThere;
    }

    public void setThere(boolean there) {
        isThere = there;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_column;
    }
}
