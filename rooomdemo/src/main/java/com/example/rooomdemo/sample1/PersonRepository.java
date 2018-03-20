package com.example.rooomdemo.sample1;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.rooomdemo.sample1.entity.Person;

import java.util.List;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
public class PersonRepository {
    private final PersonDAO personDAO;

    public PersonRepository(Context context) {
        personDAO = DatabaseCreator.getPersonDatabase(context)
                .PersonDatabase();
    }

    public void addPerson(Person person) {
        long insertPerson = personDAO.insertPerson(person);
    }

    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    public void deletePerson(Person person) {
        personDAO.deletePerson(person);
    }

    public LiveData<List<Person>> getAllPersons() {
        return personDAO.getAllPersons();
    }

    public List<Person> getPersonByCity(List<String> cities) {
        return personDAO.getPersonByCities(cities);
    }

    public LiveData<Person> getPersonByMobile(String mobile) {
        return personDAO.getPersonByMobile(mobile);
    }

}
