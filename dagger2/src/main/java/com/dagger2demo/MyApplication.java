package com.dagger2demo;

import android.app.Application;

import com.dagger2demo.module.DaggerStorageComponent;
import com.dagger2demo.module.StorageComponent;
import com.dagger2demo.module.StorageModule;
import com.dagger2demo.module.Student;

/**
 * Created by latitude on 11/09/15.
 */
public class MyApplication extends Application {

    StorageComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerStorageComponent
                .builder()
                .storageModule(new StorageModule(this))
                .student(new Student(0, "no name"))
                .build();
    }

    public StorageComponent getComponent() {
        return component;
    }
}
