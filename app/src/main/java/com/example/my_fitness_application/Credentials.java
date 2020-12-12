package com.example.my_fitness_application;

public class Credentials {

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
}
