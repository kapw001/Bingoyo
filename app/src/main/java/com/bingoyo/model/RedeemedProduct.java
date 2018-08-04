package com.bingoyo.model;

import com.bingoyo.R;
import com.bingoyo.commonadapter.ViewLayout;

public class RedeemedProduct implements ViewLayout {


    private String price_aviled;

    public String getPrice_aviled() {
        return price_aviled;
    }

    public void setPrice_aviled(String price_aviled) {
        this.price_aviled = price_aviled;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_item_redeemed_rewards;
    }
}
