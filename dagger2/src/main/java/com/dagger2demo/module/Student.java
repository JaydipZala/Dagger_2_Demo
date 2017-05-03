package com.dagger2demo.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by latitude on 2/5/17.
 */
@Module
public class Student {
    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Singleton
    @Provides
    Student providesStudent() {
        return new Student(id, name);
    }
}
