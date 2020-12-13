package com.example.my_fitness_application;

import android.app.Application;
import android.content.Context;

import java.util.List;

public class UserRepository {

    private CredentialsDAO credentialsDAO;

    private static UserRepository INSTANCE;

    private Context context;


    public static UserRepository getRepository(Context aContext){
        if(INSTANCE == null){
            synchronized (UserRepository.class){
                if(INSTANCE == null){
                    INSTANCE = new UserRepository();
                    INSTANCE.context = aContext;
                    UserDatabase db = UserDatabase.getDatabase(aContext);
                    INSTANCE.credentialsDAO = db.credentialsDAO();
                }
            }
        }
        return INSTANCE;
    }


    public void storeCredentials(Credentials credentials){
        this.credentialsDAO.insert(credentials);
    }

    public List<Credentials> getCredentialsFor(String username){
        return credentialsDAO.getCredentialsFor(username);
    }


}
