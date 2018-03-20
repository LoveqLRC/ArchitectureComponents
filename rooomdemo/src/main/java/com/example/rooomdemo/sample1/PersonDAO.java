package com.example.rooomdemo.sample1;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rooomdemo.sample1.entity.Person;

import java.util.List;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
@Dao
public interface PersonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertPerson(Person person);

    @Update
    public void updatePerson(Person person);

    @Delete
    public void deletePerson(Person person);

    @Query("SELECT * FROM PERSON")
    public LiveData<List<Person>> getAllPersons();

    @Query("SELECT * FROM PERSON WHERE mobile =:mobileIn")
    public LiveData<Person> getPersonByMobile(String mobileIn);

    @Query("SELECT * FROM PERSON WHERE CITY IN (:cityIn)")
    public List<Person> getPersonByCities(List<String> cityIn);

}
