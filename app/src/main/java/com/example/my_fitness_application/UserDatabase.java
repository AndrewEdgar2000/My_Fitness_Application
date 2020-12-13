package com.example.my_fitness_application;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = (Credentials.class), version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract CredentialsDAO credentialsDAO();

    public static UserDatabase INSTANCE;

    public static UserDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (UserDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, UserDatabase.class, "User_Database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
