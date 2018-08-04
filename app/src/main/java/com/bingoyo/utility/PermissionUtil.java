package com.bingoyo.utility;

import android.Manifest;

public enum PermissionUtil {

    RECORD_AUDIO(Manifest.permission.RECORD_AUDIO),
    CAMERA(Manifest.permission.CAMERA),
    CAM_EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE),
    EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE),
    READ_CONTACT(Manifest.permission.READ_CONTACTS),
    ACCESS_FINE_LOCATION(Manifest.permission.ACCESS_FINE_LOCATION),
    CALL_PHONE(Manifest.permission.CALL_PHONE);

    private String PermissionName;

    PermissionUtil(String permissionName) {
        this.PermissionName = permissionName;
    }

    public String getPermission() {
        return PermissionName;
    }

}
