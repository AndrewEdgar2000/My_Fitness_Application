package com.example.my_fitness_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private FloatingActionButton eNewTask, eNewsFeed, eProfile, eLogOut;
    private TextView eUserName;

    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private ArrayList<ScheduledTasks> list;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recyclerView = findViewById(R.id.rvTasks);
        eUserName = findViewById(R.id.tvUserName);
        eNewsFeed = findViewById(R.id.fabNewsFeed);
        eNewTask = findViewById(R.id.fabAddTask);
        eLogOut = findViewById(R.id.fabLogOut);
        eProfile = findViewById(R.id.fabProfile);

        final String name = getIntent().getStringExtra("name");
        final String pass = getIntent().getStringExtra("pass");
        eUserName.setText("Welcome " + name + "!");

        /*
        String taskTitle = getIntent().getStringExtra("Title");
        String taskDesc = getIntent().getStringExtra("Desc");
        final String taskDate = getIntent().getStringExtra("Date");
        */

        /*
        recyclerView.setLayoutManager(new LinearLayoutManager(HomePageActivity.this));
        list = new ArrayList<ScheduledTasks>();

        reference = FirebaseDatabase.getInstance().getReference().child("My_Fitness_Application");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    ScheduledTasks p = dataSnapshot1.getValue(ScheduledTasks.class);
                    list.add(p);
                }
                taskAdapter = new TaskAdapter(HomePageActivity.this, list);
                recyclerView.setAdapter(taskAdapter);
                taskAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });

         */

        eProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, ProfileActivity.class)
                        .putExtra("name", name).putExtra("pass", pass));
            }
        });

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