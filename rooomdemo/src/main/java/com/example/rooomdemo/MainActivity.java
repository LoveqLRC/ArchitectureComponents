package com.example.rooomdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rooomdemo.sample1.DatabaseCreator;
import com.example.rooomdemo.sample1.entity.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void getAllPersons(View view) {
        LiveData<List<Person>> allPersonsLive = DatabaseCreator.getPersonDatabase(this).PersonDatabase()
                .getAllPersons();
        allPersonsLive.observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> person) {
                if (person == null) {
                    return;
                }
                Toast.makeText(MainActivity.this, "Number of person objects in the response: " + person.size(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
