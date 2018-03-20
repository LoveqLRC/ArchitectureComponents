package com.example.rooomdemo.sample1;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
public class DatabaseCreator {
    private static PersonDatabase personDatabase;
    private static final Object LOCK = new Object();

    public static PersonDatabase getPersonDatabase(Context context) {
        if (personDatabase == null) {
            synchronized (LOCK) {
                if (personDatabase == null) {
                    personDatabase = Room.databaseBuilder(context,
                            PersonDatabase.class, "person.db")
                            .build();
                }
            }
        }
        return personDatabase;
    }

}
