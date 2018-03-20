package com.example.rooomdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
public class App  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
