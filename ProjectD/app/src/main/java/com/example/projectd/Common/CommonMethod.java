package com.example.projectd.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class CommonMethod {

    /*public static String  ipConfig = "http://192.168.200.151:8989";*/
    /*public static String ipConfig = "http://192.168.0.178:8080";*/
    //public static String ipConfig = "http://121.148.239.200:80";
    /*public static String ipConfig = "http://192.168.1.8:8989";*/
    /*public static String ipConfig = "http://172.30.1.28:80";*/
    public static String ipConfig = "http://192.168.0.71:8080";

    // 네트워크에 연결되어 있는 지 확인해주는 메소드
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d("isconnected : ", "WIFI 로 설정됨");
            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                Log.d("isconnected : ", "일반망으로 설정됨");
            }
            Log.d("isconnected : ", "OK => " + info.isConnected());
            return true;
        } else {
            Log.d("isconnected : ", "False => 데이터 통신 불가!!!");
            return false;
        }
    } //isNetworkConnected()
} //class