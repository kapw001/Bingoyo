package com.bingoyo.dashboard.editprofile;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.bingoyo.R;
import com.bingoyo.base.InitViewBaseActivity;
import com.bingoyo.cameraorgallery.CameraAndGallary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class EditProfile extends InitViewBaseActivity implements CameraAndGallary.CameraAndGallaryCallBack {

    private static final int RC_READ_WRITE = 123;
    @BindView(R.id.profile_update)
    RelativeLayout profileUpdate;
    @BindView(R.id.name)
    AppCompatEditText name;
    @BindView(R.id.nick_name)
    AppCompatEditText nickName;
    @BindView(R.id.phone_number)
    AppCompatEditText phoneNumber;
    @BindView(R.id.age_group)
    Spinner ageGroup;
    @BindView(R.id.email)
    AppCompatEditText email;
    @BindView(R.id.country)
    AppCompatEditText country;
    @BindView(R.id.date_of_birth)
    AppCompatTextView dateOfBirth;
    @BindView(R.id.profile)
    CircleImageView profile;
    @BindView(R.id.img_upload)
    ImageView imgUpload;

    private boolean isEditMode = false;


    @BindViews({R.id.profile_update, R.id.name, R.id.nick_name, R.id.phone_number, R.id.age_group, R.id.email, R.id.country, R.id.date_of_birth, R.id.img_upload})
    List<View> viewList;

    private CameraAndGallary cameraAndGallary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenGradientColor();
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        setButterKnife();
        setBackButtonEnabledAndTitle("Edit Profile");

        intView();
    }

    @Override
    protected void intView() {

        ButterKnife.apply(viewList, ENABLED, isEditMode);

        cameraAndGallary = new CameraAndGallary(this, this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editprofile, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.edit_save) {

            if (isEditMode) {
                item.setIcon(R.drawable.ic_edit_black_24dp);

            } else {
                item.setIcon(R.drawable.ic_check_black_24dp);
            }

            isEditMode = !isEditMode;

            ButterKnife.apply(viewList, ENABLED, isEditMode);
        }


        return super.onOptionsItemSelected(item);
    }


    static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(View view, Boolean value, int index) {
            view.setEnabled(value);

            if (view.getId() == R.id.img_upload) {

                if (value) view.setVisibility(View.VISIBLE);
                else view.setVisibility(View.GONE);
            }
        }
    };


    @OnClick({R.id.profile_update, R.id.date_of_birth})
    public void onClick(View view) {


        switch (view.getId()) {


            case R.id.profile_update:
                phoneStatePermission();

                break;

            case R.id.date_of_birth:


                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                        String myFormat = "dd MMMM yyyy"; // your format
                        String myFormat = "dd-MM-yyyy"; // your format
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

                        dateOfBirth.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();


                break;

        }


    }


    @AfterPermissionGranted(RC_READ_WRITE)
    protected void phoneStatePermission() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
//            // Already have permission, do the thing

            cameraAndGallary.selectImage();
//            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.read_write_rationale),
                    RC_READ_WRITE, perms);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cameraAndGallary.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSelectFromGalleryResult(Bitmap bitmap) {

        profile.setImageBitmap(bitmap);
    }
}
