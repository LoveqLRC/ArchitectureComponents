package com.example.baserxjavasample.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/3/16.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM USERS LIMIT 1")
    Flowable<User> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);


    @Query("DELETE FROM Users")
    void deleteAllUsers();
}
