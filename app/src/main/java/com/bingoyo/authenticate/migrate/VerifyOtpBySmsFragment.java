package com.bingoyo.authenticate.migrate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bingoyo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyOtpBySmsFragment extends Fragment {


    public VerifyOtpBySmsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_otp_by_sms, container, false);
    }

}