package com.bingoyo.dashboard.earnings;

import android.content.Context;

import com.bingoyo.base.BaseFragment;

public class EarningBaseFragment extends BaseFragment {

    protected ViewChangeCallBack viewChangeCallBack;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        viewChangeCallBack = (ViewChangeCallBack) context;
    }
}
