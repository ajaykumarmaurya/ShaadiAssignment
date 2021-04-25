package com.assignment.shaadi.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.assignment.shaadi.BuildConfig;
import com.assignment.shaadi.entities.user.MyObjectBox;
import com.assignment.shaadi.services.MainService;

import dagger.hilt.android.HiltAndroidApp;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

@HiltAndroidApp
public class MainApplication extends Application {

    private static Context appContext;

    public static final String LOG_TAG = "custom-tag";

    private static BoxStore boxStore;

    private static MainService mainService;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

        boxStore = MyObjectBox.builder().androidContext(this).build();

        if (BuildConfig.DEBUG) {
            boolean started = new AndroidObjectBrowser(boxStore).start(this);
            Log.i("ObjectBrowser", "Started: " + started);
        }
    }


    public static MainService getMainService() {
        if (mainService == null) {
            mainService = RetrofitBuilder.buildMainApiService(MainService.class);
        }
        return mainService;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }


}
