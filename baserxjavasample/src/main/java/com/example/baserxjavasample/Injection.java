package com.example.baserxjavasample;

import android.content.Context;

import com.example.baserxjavasample.persistence.LocalUserDataSource;
import com.example.baserxjavasample.persistence.UsersDatabase;
import com.example.baserxjavasample.ui.ViewModelFactory;

/**
 * Created by Administrator on 2018/3/16.
 */

public class Injection {
    public static UserDataSource provideUserDataSource(Context context) {
        UsersDatabase database = UsersDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }

}
