package com.example.my_fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eUsername, ePassword;
    private Button eLogin, eSignUp;
    private TextView eNumAttempts;
    private CheckBox eRememberMe;

    boolean isValid = false;
    private int count = 5;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eUsername = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eSignUp = findViewById(R.id.btnSignUp);
        eNumAttempts = findViewById(R.id.tvNumAttempts);
        eRememberMe = findViewById(R.id.cbRememberMe);

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        if(sharedPreferences != null){
            String savedUsername = sharedPreferences.getString("Username", "");
            String savedPassword = sharedPreferences.getString("Password", "");

            RegisterActivity.credentials = new Credentials(savedUsername, savedPassword);

            if(sharedPreferences.getBoolean("RememberMeCheckBox", false)){
                eUsername.setText(savedUsername);
                ePassword.setText(savedPassword);
                eRememberMe.setChecked(true);
            }
        }

        eRememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferencesEditor.putBoolean("RememberMeCheckBox", eRememberMe.isChecked());
                sharedPreferencesEditor.apply();
            }
        });


        //On click listener to login in to the application
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputUsername = eUsername.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputUsername.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all the required details.", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputUsername, inputPassword);
                    if(!isValid){
                        count --;
                        Toast.makeText(MainActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();
                        eNumAttempts.setText("Number of attempts remaining: " + count);
                        if(count == 0){
                            eLogin.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        //Add code to go to next activity
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        //On click listener to get to the registration page
        eSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    //Validate function checks if the credentials put into the login page are correct
    private boolean validate(String uName, String uPassword) {
        if(RegisterActivity.credentials != null) {
            if (uName.equals(RegisterActivity.credentials.getUsername()) && uPassword.equals(RegisterActivity.credentials.getPassword())) {
                return true;
            }
        }
        return false;
    }
}