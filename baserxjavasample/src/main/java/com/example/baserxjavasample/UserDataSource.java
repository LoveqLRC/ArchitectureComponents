package com.example.baserxjavasample;

import com.example.baserxjavasample.persistence.User;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/3/16.
 */

public interface UserDataSource {

    Flowable<User> getUser();


    void insertOrUpdateUser(User user);

    void deleteAllUsers();
}
