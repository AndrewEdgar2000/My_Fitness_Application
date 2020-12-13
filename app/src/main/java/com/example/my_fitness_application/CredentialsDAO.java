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
    void insert(Credentials aCredentials);

    @Query("SELECT * from Credentials where uid=(:uid) and password=(:password)")
    Credentials login(String uid, String password);

}
