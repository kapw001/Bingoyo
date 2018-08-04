package com.bingoyo.authenticate;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bingoyo.R;
import com.bingoyo.authenticate.migrate.MigrateActivity;
import com.bingoyo.base.BaseFragment;
import com.bingoyo.shownearestcountry.NearestCountryActivity;
import com.bingoyo.utility.KeyboardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {

    @BindView(R.id.login)
    Button login;
    @BindView(R.id.facebook_login)
    LinearLayout facebookLogin;
    @BindView(R.id.migrate_account)
    Button migrateAccount;
    Unbinder unbinder;
    private Animation scale;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scale = AnimationUtils.loadAnimation(getContext(), R.anim.button_animation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);


        KeyboardUtils.hideKeyboard(getActivity());

        return view;
    }

    @OnTouch({R.id.login, R.id.facebook_login, R.id.migrate_account})
    public boolean onTouch(View v, MotionEvent event) {

        onTouchScaleDown(v, event);


        return true;

    }


    @Override
    protected void onClick(View v) {
        switch (v.getId()) {

            case R.id.login:

                startActivity(new Intent(getContext(), NearestCountryActivity.class));
                break;

            case R.id.facebook_login:
                showT("Flogin");
                break;

            case R.id.migrate_account:


                Intent intent = new Intent(getContext(), MigrateActivity.class);
                intent.putExtra("isMigrate", true);
                startActivity(intent);


                break;

        }

    }

    private void showT(String msg) {

        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
