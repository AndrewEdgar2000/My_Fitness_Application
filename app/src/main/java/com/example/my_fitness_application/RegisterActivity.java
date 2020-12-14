package com.example.my_fitness_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    //Attributes of Registration class
    private Button eBtnCancelReg, eBtnSignUp;
    private EditText eRegUsername, eRegPassword, eConfirmRegPassword;

    //Object for the credentials to be passed into
    public static Credentials credentials;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Attach the ui elements to the xml layout
        eBtnCancelReg = findViewById(R.id.btnCancelReg);
        eBtnSignUp = findViewById(R.id.btnSignUp);
        eRegUsername = findViewById(R.id.etRegUsername);
        eRegPassword = findViewById(R.id.etRegPassword);
        eConfirmRegPassword = findViewById(R.id.etConfirmRegPassword);

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();


        /*
        A listener for the register button, this will add the username and password
        to a Credentials object to be used to sign in to the app with
         */
        eBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regUsername = eRegUsername.getText().toString();
                String regPassword = eRegPassword.getText().toString();
                String regConfirmPassword = eConfirmRegPassword.getText().toString();
                credentials = new Credentials(regUsername, regPassword);

                if(validate(regUsername, regPassword, regConfirmPassword)){
                    UserDatabase userDatabase = UserDatabase.getDatabase(getApplicationContext());
                    final CredentialsDAO credentialsDAO = userDatabase.credentialsDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            credentialsDAO.insert(credentials);
                        }
                    }).start();


                    //Store the credentials to the shared preferences file
                    sharedPreferencesEditor.putString("Username", regUsername);
                    sharedPreferencesEditor.putString("Password", regPassword);
                    sharedPreferencesEditor.apply();

                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Listener for the cancel button
        eBtnCancelReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes user back to the initial login page when they click cancel
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });


    }

    //Validate function to make sure the
    private boolean validate(String username , String password, String confirmPassword){
        /*Checking to see if the fields are empty, if they are the function will return false and
          will display a message
         */
        if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            Toast.makeText(this, "Please enter all the details!", Toast.LENGTH_SHORT).show();
            return false;
        }
        /*
        Checking to see if the two password fields are the same, if not the function will return false
        and will display a message.
         */
        if(!password.equals(confirmPassword)){
            Toast.makeText(this, "The two passwords do not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}