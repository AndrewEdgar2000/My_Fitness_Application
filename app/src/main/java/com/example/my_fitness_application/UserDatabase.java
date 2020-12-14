package com.example.my_fitness_application;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Credentials.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase INSTANCE;

    public static synchronized UserDatabase getDatabase(final Context context){
        if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, UserDatabase.class, "User_Database")
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }


    public abstract CredentialsDAO credentialsDAO();
}
