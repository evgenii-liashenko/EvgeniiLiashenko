package ru.training.at.hw5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserData {

    private static Properties properties;
    private static String path = "src/test/resources/credentials.properties";

    static {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(path)){
            properties.load(inputStream);
        }catch (IOException e){
            System.out.println("Failed to load credentials.properties file");
            e.printStackTrace();
        }
    }

    public static Properties getCredentials(){
        return properties;
    }
}
