package com.example.my_fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.auth.User;

public class ProfileActivity extends AppCompatActivity {

    private TextView eProfileTitle;
    private EditText eAccName, eAccPass, eAccConfirmPass;
    private Button eCancel, eSaveChanges;
    private FloatingActionButton eLogOut, eAddTask, eNewsFeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        eProfileTitle = findViewById(R.id.tvProfile);
        eAccConfirmPass = findViewById(R.id.etConfirmProfPassword);
        eAccName = findViewById(R.id.etProfName);
        eAccPass = findViewById(R.id.etProfPassword);
        eCancel = findViewById(R.id.btnCancelProfileChanges);
        eSaveChanges = findViewById(R.id.btnSaveProfileChanges);
        eLogOut = findViewById(R.id.fabLogOut);
        eAddTask = findViewById(R.id.fabAddTask);
        eNewsFeed = findViewById(R.id.fabNewsFeed);

        final String name = getIntent().getStringExtra("name");
        String pass = getIntent().getStringExtra("pass");

        eAccName.setText(name);
        eAccPass.setText(pass);

/*
        eSaveChanges.setOnClickListener(new View.OnClickListener() {
            final String profName = eAccName.getText().toString();
            final String profPass = eAccPass.getText().toString();
            String accConfirmPassProf = eAccConfirmPass.getText().toString();

            @Override
            public void onClick(View v) {
                if(accConfirmPassProf.isEmpty()){
                    Toast.makeText(ProfileActivity.this, "Please enter all the required details.", Toast.LENGTH_SHORT).show();
                }
                if(!accConfirmPassProf.equals(profPass)){
                    Toast.makeText(ProfileActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                } else {
                    UserDatabase userDatabase = UserDatabase.getDatabase(getApplicationContext());
                    final CredentialsDAO credentialsDAO = userDatabase.credentialsDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Credentials credentials = credentialsDAO.updateProfile(profName, profPass);
                            if(credentials == null){
                                Toast.makeText(ProfileActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(ProfileActivity.this, HomePageActivity.class));
                            }
                        }
                    }).start();
                }

            }
        });
 */

        eCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomePageActivity.class));
            }
        });
        eLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
        eAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, AddTask.class));
            }
        });

    }
}