package com.bingoyo.authenticate.migrate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.bingoyo.R;
import com.bingoyo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MigrateActivity extends BaseActivity implements MigrateFragment.CallBackVerify {

    @BindView(R.id.back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migrate);
        setButterKnife();


        boolean isFromMigrate = getIntent().getBooleanExtra("isMigrate", false);

        if (isFromMigrate)
            loadFragment(new MigrateFragment());
        else loadFragment(new MigrateVerifyFragment());


    }


    private void loadFragment(Fragment fragment) {


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment);

        fragmentTransaction.commit();


    }


    @OnClick(R.id.back)
    public void onClick(View view) {

        onBackPressed();

    }

    @Override
    public void onVerify() {

        loadFragment(new MigrateVerifyFragment());

    }
}
