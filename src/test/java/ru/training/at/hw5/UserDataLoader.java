package ru.training.at.hw5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDataLoader {

    private static final String filePath = "src/test/resources/credentials.properties";

    public static Properties getCredentials(){
        FileInputStream fileInputStream;
        Properties credentials = new Properties();
        try {
            fileInputStream = new FileInputStream(filePath);
            credentials.load(fileInputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return credentials;
    }

}
