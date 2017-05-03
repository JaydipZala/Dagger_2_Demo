package com.dagger2demo.module;

import com.dagger2demo.FragmentA;
import com.dagger2demo.FragmentB;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by latitude on 2/5/17.
 */
@Singleton
@Component(
        modules = {
                StorageModule.class,
                Student.class
        })
public interface StorageComponent {
    void inject(FragmentA fragmentA);

    void inject(FragmentB fragmentB);
}
