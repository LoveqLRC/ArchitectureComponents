package com.example.rooomdemo.sample1;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.rooomdemo.sample1.entity.Person;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDAO PersonDatabase();

}
