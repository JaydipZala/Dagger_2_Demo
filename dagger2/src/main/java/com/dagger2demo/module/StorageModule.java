package com.dagger2demo.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dagger2demo.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by latitude on 2/5/17.
 */
@Module
public class StorageModule {
    private final MyApplication myApplication;

    public StorageModule(MyApplication myApplication){
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(myApplication);
    }
}
