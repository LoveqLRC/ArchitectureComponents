package com.example.baserxjavasample.persistence;

import com.example.baserxjavasample.UserDataSource;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/3/16.
 */

public class LocalUserDataSource implements UserDataSource {

    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao mUserDao) {
        this.mUserDao = mUserDao;
    }

    @Override
    public Flowable<User> getUser() {
        return mUserDao.getUser();
    }

    @Override
    public void insertOrUpdateUser(User user) {
        mUserDao.insertUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllUsers();
    }
}
