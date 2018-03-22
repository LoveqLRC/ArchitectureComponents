package com.example.rooomdemo.sample1.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.rooomdemo.sample1.entity.Address;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
@Entity
public class Person {
    private String name;
    @PrimaryKey
    @NonNull
    private String mobile;
    private String email;
    @Embedded
    private Address address;
    private String type;
    @Ignore
    private String middleName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
