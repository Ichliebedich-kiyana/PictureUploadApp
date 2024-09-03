package com.example.pictureupload;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;
    public static List<Activity> lists;
    private static volatile MyApplication myApp;
    public static SimpleDateFormat format;

    public static MyApplication getInstance(){
        if(myApp==null){
            myApp = new MyApplication();
        }
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences("sp",MODE_PRIVATE);
        editor = sp.edit();
        lists = new ArrayList<>();
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static SharedPreferences getSp() {
        return sp;
    }

    public static void setSp(SharedPreferences sp) {
        MyApplication.sp = sp;
    }

    public static SharedPreferences.Editor getEditor() {
        return editor;
    }

    public static void setEditor(SharedPreferences.Editor editor) {
        MyApplication.editor = editor;
    }



    public static void addAct(Activity activity){
        lists.add(activity);
    }

    /**
     * 删除指定activity
     * @param activity
     */
    public static void removeActivity(Activity activity){
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i)==activity){
                lists.remove(i);
                break;
            }
        }
    }

    public static void removeAll(){
        if(lists.size()>0){
            for (Activity list : lists) {
                list.finish();
            }
        }
    }

}
