package com.example.baserxjavasample.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * Created by Administrator on 2018/3/16.
 */

@Entity(tableName = "users")
public class User {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userid")
    private String mId;

    @ColumnInfo(name = "username")
    private String mUserName;

    @Ignore
    public User(String mUserName) {
        mId = UUID.randomUUID().toString();
        this.mUserName = mUserName;
    }

    public User(@NonNull String mId, String mUserName) {
        this.mId = mId;
        this.mUserName = mUserName;
    }

    @NonNull
    public String getId() {
        return mId;
    }

    public String getUserName() {
        return mUserName;
    }
}
