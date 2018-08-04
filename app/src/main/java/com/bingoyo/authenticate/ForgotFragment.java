package com.bingoyo.authenticate;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.UtilAnim;
import com.bingoyo.base.BaseFragment;
import com.bingoyo.pinview.Pinview;
import com.bingoyo.utility.KeyboardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotFragment extends BaseFragment {


    @BindView(R.id.request_otp)
    Button requestOtp;
    Unbinder unbinder;
    @BindView(R.id.verify_otp)
    Button verifyOtp;
    @BindView(R.id.resend_otp)
    TextView resendOtp;
    @BindView(R.id.layout_request_otp)
    RelativeLayout layoutRequestOtp;
    @BindView(R.id.layout_otp_digits)
    LinearLayout layoutOtpDigits;
    @BindView(R.id.layout_verify_otp)
    LinearLayout layoutVerifyOtp;
    @BindView(R.id.mobile_number)
    AppCompatEditText mobileNumber;
    @BindView(R.id.pinview)
    Pinview pinview;

    private int otp = 123456;

    public ForgotFragment() {
        // Required empty public constructor
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot, container, false);
        unbinder = ButterKnife.bind(this, view);

//        verifyOtp.setEnabled(false);
//        verifyOtp.setAlpha(.2f);

//        enableHide(false, .2f);
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                int v = Integer.parseInt(pinview.getValue());
                if (pinview.getValue().length() == 6) {
                    enableHide(true, 1f);
                }
            }
        });

        KeyboardUtils.hideKeyboard(getActivity());

        return view;
    }


    private void enableHide(boolean isEnsbled, float alpha) {

        verifyOtp.setEnabled(isEnsbled);
        verifyOtp.setAlpha(alpha);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.request_otp, R.id.verify_otp})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.request_otp:

                if (validate()) {

                    KeyboardUtils.hideKeyboard(getActivity());

                    UtilAnim.hideAnimation(layoutRequestOtp);
                    UtilAnim.showAnimation(layoutVerifyOtp);
                    UtilAnim.moveAnimation(layoutOtpDigits);

                } else {

                    showToast("Please enter mobile number");
                }

                break;

            case R.id.verify_otp:

                if (pinview.getValue().length() > 0 && otp == Integer.parseInt(pinview.getValue())) {

//                    showToast("Otp verified");


                    startActivity(new Intent(getContext(), ChangePassWordActivity.class));

                } else {

                    showToast("Otp does not match,Please enter again");

                    if (pinview.getValue().length() > 0)
                        pinview.clearValue();
                    enableHide(false, .2f);

                }


                break;

        }

    }


    private boolean validate() {

        boolean isValid = false;

        if (mobileNumber.getText().length() > 0) {

            isValid = true;
        }


        return isValid;

    }
}
