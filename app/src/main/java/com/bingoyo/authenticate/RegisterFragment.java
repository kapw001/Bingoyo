package com.bingoyo.authenticate;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bingoyo.R;
import com.bingoyo.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment {
    private static final String TAG = "RegisterFragment";
    @BindView(R.id.signup)
    Button signup;
    @BindView(R.id.layout_register)
    RelativeLayout layoutRegister;
    @BindView(R.id.layout_request_otp)
    RelativeLayout layoutRequestOtp;
    Unbinder unbinder;
    @BindView(R.id.terms_condition)
    AppCompatRadioButton termsCondition;
    @BindView(R.id.age_group)
    Spinner ageGroup;
    private CallBackFragment callBackFragment;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callBackFragment = (CallBackFragment) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        setButterKnife(this, view);

        hideKeyboardFrom(getContext(), view);
        unbinder = ButterKnife.bind(this, view);


        termsCondition.setText(Html.fromHtml("I accept the " +
                "<a style=\"color:DodgerBlue;\" href='https://www.google.com'>Terms & Conditions</a>"));
        termsCondition.setClickable(true);
        termsCondition.setMovementMethod(LinkMovementMethod.getInstance());
        init();

        return view;
    }


    private void init() {


        String[] age_group = getResources().getStringArray(R.array.age_group);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, age_group) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                ((TextView) v).setTextSize(12);
                if (position == 0) {
//                    ((TextView) v).setTextSize(16);
                    ((TextView) v).setTextColor(getColor(R.color.tabUnSelectedColor)
                    );
                }
                return v;

            }

        };

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageGroup.setAdapter(arrayAdapter);


    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getView() != null) {
            layoutRequestOtp.setVisibility(View.GONE);
            layoutRegister.setVisibility(View.VISIBLE);
        }

    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    @OnTouch(R.id.signup)
    public boolean onTouch(View v, MotionEvent event) {


        onTouchScaleDown(v, event);

        return true;
    }

    @Override
    protected void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {

            case R.id.signup:

//                showToast("Signup");

                layoutRequestOtp.setVisibility(View.VISIBLE);
                layoutRegister.setVisibility(View.GONE);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public interface CallBackFragment {

        void callRequestFragment();
    }
}
