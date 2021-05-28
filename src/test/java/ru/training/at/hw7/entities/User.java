package ru.training.at.hw7.entities;

import ru.training.at.hw7.testdata.TestDataLoader;

import java.util.Properties;

public class User {

    private String name;
    private String password;
    private String fullName;

    //Constructors
    public User() {
        System.out.println("Creating default User object");
        Properties credentials = TestDataLoader.getCredentials();
        this.name = credentials.getProperty("username");
        this.password = credentials.getProperty("password");
        this.fullName = "Roman Iovlev";
    }
    public User(String name, String password, String fullName) {
        System.out.println("Creating User object with full arg constructor");
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getFullName() {
        return fullName;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
