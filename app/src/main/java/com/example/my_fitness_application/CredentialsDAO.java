package com.example.my_fitness_application;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CredentialsDAO {

    @Insert
    public void insert(Credentials aCredentials);

    @Query("SELECT * from Credentials where username =(:username) and password=(:password)")
    public Credentials login(String username, String password);

}
