package com.bingoyo.authenticate.migrate;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bingoyo.R;
import com.bingoyo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MigrateFragment extends BaseFragment {

    private static final String TAG = "MigrateFragment";
    @BindView(R.id.email)
    AppCompatEditText email;
    @BindView(R.id.mobile_number)
    AppCompatEditText mobileNumber;
    @BindView(R.id.migrate)
    Button migrate;
    Unbinder unbinder;

    private CallBackVerify callBackVerify;

    public MigrateFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callBackVerify = (CallBackVerify) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_migrate, container, false);
        setButterKnife(this, view);
        return view;
    }


    @OnClick(R.id.migrate)
    public void onClick(View view) {

        if (callBackVerify != null) {

            callBackVerify.onVerify();
        } else {

            Log.e(TAG, "onClick: migrate callback not init ");
        }

    }


    public interface CallBackVerify {

        void onVerify();

    }

}
