package com.example.rooomdemo.sample1;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Transformations;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.rooomdemo.sample1.entity.Person;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Email 664215432@qq.com
 * Created by Rc on 2018/3/20.
 * Version 1.0
 * Description:
 */
public class PersonViewModel extends AndroidViewModel {
    private PersonRepository personRepository = new PersonRepository(this.getApplication());

    private final Executor executor = Executors.newFixedThreadPool(2);

    private final MediatorLiveData<List<Person>> personsByCity = new MediatorLiveData<>();

    private final MediatorLiveData<String> mobileNo = new MediatorLiveData<>();

    private final LiveData<Person> personByMobile = Transformations.switchMap(mobileNo,
            new Function<String, LiveData<Person>>() {
                @Override
                public LiveData<Person> apply(String input) {
                    return personRepository.getPersonByMobile(input);
                }
            });

    public LiveData<List<Person>> getPersonsByCityLive() {
        return personsByCity;
    }

    public void addPerson(final Person person) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personRepository.addPerson(person);
            }
        });
    }

    public void updatePerson(final Person person) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personRepository.updatePerson(person);
            }
        });
    }

    public void deletePerson(final Person person) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personRepository.deletePerson(person);
            }
        });
    }

    public LiveData<List<Person>> getAllPersons() {
        return personRepository.getAllPersons();
    }

    public void getPersonByCity(final List<String> cities) {
        new AsyncTask<Void, Void, List<Person>>() {

            @Override
            protected List<Person> doInBackground(Void... voids) {

                return personRepository.getPersonByCity(cities);
            }

            @Override
            protected void onPostExecute(List<Person> people) {
                personsByCity.setValue(people);
            }
        }.execute();
    }

    public void setMobile(String mobile) {
        mobileNo.setValue(mobile);
    }

    public LiveData<Person> getPersonsByMobile() {
        return personByMobile;
    }


    public PersonViewModel(@NonNull Application application) {
        super(application);
    }
}
