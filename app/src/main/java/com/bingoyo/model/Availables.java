package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

import java.util.List;

public class Availables implements ViewLayout {


    private String title;

    private boolean isRedeemed = false;

    private List<RedeemedProduct> redeemedProductList;

    public boolean isRedeemed() {
        return isRedeemed;
    }

    public void setRedeemed(boolean redeemed) {
        isRedeemed = redeemed;
    }

    public List<RedeemedProduct> getRedeemedProductList() {
        return redeemedProductList;
    }

    public void setRedeemedProductList(List<RedeemedProduct> redeemedProductList) {
        this.redeemedProductList = redeemedProductList;
    }

    private List<AvailableProduct> list;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AvailableProduct> getList() {
        return list;
    }

    public void setList(List<AvailableProduct> list) {
        this.list = list;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_rewards_available;
    }

}
