package com.example.my_fitness_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private FloatingActionButton eNewTask, eNewsFeed, eProfile, eLogOut;
    private TextView eUserName;

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private ScheduledTasks scheduledTasks;
    private ArrayList<ScheduledTasks> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eUserName = findViewById(R.id.tvUserName);
        eNewsFeed = findViewById(R.id.fabNewsFeed);
        eNewTask = findViewById(R.id.fabAddTask);
        eLogOut = findViewById(R.id.fabLogOut);
        eProfile = findViewById(R.id.fabProfile);

        String name = getIntent().getStringExtra("name");
        eUserName.setText("Welcome " + name + "!");

        if(list == null){
            //Continue
        } else {
            String taskTitle = getIntent().getStringExtra("Title");
            String taskDesc = getIntent().getStringExtra("Desc");
            String taskDate = getIntent().getStringExtra("Date");

            scheduledTasks = new ScheduledTasks(taskTitle, taskDesc, taskDate);
            list.add(scheduledTasks);
            taskAdapter = new TaskAdapter(HomePageActivity.this, list);
            recyclerView.setAdapter(taskAdapter);
            taskAdapter.notifyDataSetChanged();

        }

        eLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
            }
        });

        eNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, AddTask.class));
            }
        });


    }
}