package com.example.baserxjavasample.ui;

import android.arch.lifecycle.ViewModel;

import com.example.baserxjavasample.UserDataSource;
import com.example.baserxjavasample.persistence.User;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.functions.Action;

/**
 * Created by Administrator on 2018/3/16.
 */

public class UserViewModel extends ViewModel {
    private final UserDataSource mDataSource;

    private User mUser;

    public UserViewModel(UserDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    public Flowable<String> getUserName() {
        return mDataSource.getUser()
                .map(user -> {
                    mUser = user;
                    return user.getUserName();
                });
    }

    public Completable updateUserName(final String userName) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mUser = mUser == null
                        ? new User(userName)
                        : new User(mUser.getId(), userName);

                mDataSource.insertOrUpdateUser(mUser);
            }
        });
    }

}
