package com.example.baserxjavasample.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.baserxjavasample.UserDataSource;

/**
 * Created by Administrator on 2018/3/16.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final UserDataSource mDataSource;

    public ViewModelFactory(UserDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }


}
