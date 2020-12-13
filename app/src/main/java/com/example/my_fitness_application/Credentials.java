package com.example.my_fitness_application;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Credentials")
public class Credentials {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String username;
    private String password;

    public Credentials(String aUsername, String aPassword){
        this.username = aUsername;
        this.password = aPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String aUsername) {
        this.username = aUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String aPassword) {
        this.password = aPassword;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
