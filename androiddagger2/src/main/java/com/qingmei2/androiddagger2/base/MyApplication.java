package com.qingmei2.androiddagger2.base;

import android.app.Activity;
import android.app.Application;

import com.qingmei2.androiddagger2.di.DaggerMyAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * Created by QingMei on 2017/7/28.
 * desc:
 */

public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyAppComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

}
