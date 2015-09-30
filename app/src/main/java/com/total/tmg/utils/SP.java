package com.total.tmg.utils;

import android.content.Context;


/**
 * system's data, like:login key, update,role. SysData.java
 *
 * @author ibangbang@qq.com
 * @date 2015-2-11
 */
public class SP {
    private static final String TAG = SP.class.getSimpleName();

    private static final String SYS_FIRST_TIME = "FIRST_TIME";
    private static final String SYS_LOGINED = "LOGINED";
    private static final String SYS_PHONE = "PHONE";
    private static final String SYS_PWD = "PWD";
    private static final String SYS_USER_ID = "USER_ID";

    private static final String SYS_TOKEN = "TOKEN";

    private static final String SYS_SETTING_PUSH = "FUNCTION_SETTING_PUSH";
    private static final String SYS_SETTING_BATTERY = "FUNCTION_SETTING_BATTERY";
    private static final String SYS_SETTING_CLOSE = "FUNCTION_SETTING_CLOSE";

    private static final int TIME_INTERVEL = 24;

    public static boolean isLogined(Context context) {
        L.e(TAG, "isLogined");
        return (Boolean) SPUtils.get(context, SYS_LOGINED, false);
    }

    public static String getPhone(Context context) {
        L.e(TAG, "get phone");
        return (String) SPUtils.get(context, SYS_PHONE, "");
    }

    public static void setPhone(Context context, String phone) {
        L.e(TAG, "set phone");
        if (phone != null)
            SPUtils.put(context, SYS_PHONE, phone);
    }

    public static String getSysPwd(Context context) {
        L.e(TAG, "get syspwd");
        return (String) SPUtils.get(context, SYS_PWD, "");
    }

    public static void setSysPwd(Context context, String pwd) {
        L.e(TAG, "put syspwd");
        if (pwd != null)
            SPUtils.put(context, SYS_PWD, pwd);
        else
            SPUtils.put(context, SYS_PWD, "");
    }

    public static String getUserId(Context context) {
        L.e(TAG, "get userid");
        return (String) SPUtils.get(context, SYS_USER_ID, "");
    }

    public static void setUserId(Context context, String userId) {
        L.e(TAG, "set userid");
        if (userId != null)
            SPUtils.put(context, SYS_USER_ID, userId);
    }

    public static String getToken(Context context) {
        L.e(TAG, "get token");
        return (String) SPUtils.get(context, SYS_TOKEN, "");
    }

    public static void setToken(Context context, String token) {
        L.e(TAG, "set token");
        if (token != null)
            SPUtils.put(context, SYS_TOKEN, token);
    }

    public static void setPush(Context context, boolean value) {
        L.e(TAG, "set push");
        SPUtils.put(context, SYS_SETTING_PUSH, value);
    }

    public static boolean getPush(Context context) {
        L.e(TAG, "get push");
        return (Boolean) SPUtils.get(context, SYS_SETTING_PUSH, true);
    }

    public static void setBatterModel(Context context, boolean value) {
        L.e(TAG, "set battery");
        SPUtils.put(context, SYS_SETTING_BATTERY, value);
    }

    public static boolean getCloseDevice(Context context) {
        L.e(TAG, "get getCloseDevice");
        return (Boolean) SPUtils.get(context, SYS_SETTING_CLOSE, false);
    }

    public static void setCloseDevice(Context context, boolean value) {
        L.e(TAG, "set setCloseDevice");
        SPUtils.put(context, SYS_SETTING_CLOSE, value);
    }

    public static boolean getBatteryModel(Context context) {
        L.e(TAG, "getbattery");
        return (Boolean) SPUtils.get(context, SYS_SETTING_BATTERY, false);
    }

    public static void clear(Context context) {
        SPUtils.clear(context);
    }

}
