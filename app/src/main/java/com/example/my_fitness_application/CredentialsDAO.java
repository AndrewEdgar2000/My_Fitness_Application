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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Credentials aCredentials);

    @Update
    public void update(Credentials aCredentials);


    @Delete
    public void delete(Credentials aCredentials);

    @Query("SELECT * from Credentials where username LIKE :aUsername")
    public List<Credentials> getCredentialsFor(String aUsername);

}
