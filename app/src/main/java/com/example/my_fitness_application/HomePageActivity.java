package com.example.my_fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomePageActivity extends AppCompatActivity {

    private FloatingActionButton eNewTask, eNewsFeed, eProfile, eLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eNewsFeed = findViewById(R.id.fabNewsFeed);
        eNewTask = findViewById(R.id.fabAddTask);
        eLogOut = findViewById(R.id.fabLogOut);
        eProfile = findViewById(R.id.fabProfile);

        eLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
            }
        });
        eProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
            }
        });
    }
}