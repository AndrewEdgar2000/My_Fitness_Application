package com.example.my_fitness_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {

    private FloatingActionButton eProf, eLog, eNews;
    private TextView eAddTask;
    private EditText eTaskTitle, eTaskDate, eTaskDesc;
    private Button eAddNewTask, eCancelAddTask;

    private RecyclerView recyclerView;
    private ArrayList<ScheduledTasks> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        eAddNewTask = findViewById(R.id.btnSaveNewTask);
        eCancelAddTask = findViewById(R.id.btnCancelAddTask);
        eAddTask = findViewById(R.id.tvAddNewTask);
        eTaskTitle = findViewById(R.id.etTaskTitle);
        eTaskDate = findViewById(R.id.etTaskDate);
        eTaskDesc = findViewById(R.id.etTaskDesc);
        eProf = findViewById(R.id.fabProfile);
        eLog = findViewById(R.id.fabLogOut);
        eNews = findViewById(R.id.fabNewsFeed);

        eAddNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskTitle = eTaskTitle.getText().toString();
                String taskDesc = eTaskDesc.getText().toString();
                String taskDate = eTaskDate.getText().toString();
                Toast.makeText(AddTask.this, "Task added successfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddTask.this, HomePageActivity.class).putExtra("Title", taskTitle)
                .putExtra("Desc", taskDesc).putExtra("Date", taskDate));
            }
        });

        eCancelAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddTask.this, HomePageActivity.class));
            }
        });
        eLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddTask.this, HomePageActivity.class));
            }
        });



    }
}