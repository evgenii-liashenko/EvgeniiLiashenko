package ru.training.at.hw7.testdata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class TestDataLoader {
    //Paths to .json and .properties files
    private String jsonFilePath = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
    private static final String credentialsFilePath = "src/test/resources/userdata.properties";

    //All data sets with test values from the json file
    private Map<String, TestDataSet> allTestData = extractDataFromJson(jsonFilePath);

    //Deserialization of the json into a map
    private Map<String, TestDataSet> extractDataFromJson(String filePath){
        Map <String, TestDataSet> extractedData = new HashMap<>();
        try {
            Reader reader = new FileReader(jsonFilePath);
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<String, TestDataSet>>(){}.getType();
            extractedData = gson.fromJson(reader, type);
        }
        catch (FileNotFoundException e){
            System.out.println("Failed to load file from path " + filePath);
            e.printStackTrace();
        }
        return extractedData;
    }

    //DataProvider method
    @DataProvider(name = "metalsAndColorsPageTestData")
    public static Object[][] jsonTestDataProvider() {
        //Gathering test data
        TestDataLoader testDataLoader = new TestDataLoader();
        Map<String, TestDataSet> testDataMap = testDataLoader.getAllTestData();

        //Converting test data to Object[][]
        Deque<TestDataSet> testDataDeque = new ArrayDeque<>();
        for (Map.Entry<String, TestDataSet> tds : testDataMap.entrySet()){
            testDataDeque.addLast(tds.getValue());
        }
        Object[][] dataProvider2dArray = new Object[testDataMap.size()][1];
        for (int i = 0; i < testDataMap.size(); i++) {
            dataProvider2dArray[i][0] = testDataDeque.removeFirst();
        }
        return dataProvider2dArray;
    }

    //Credential retrieval from .properties file
    public static Properties getCredentials(){
        FileInputStream fileInputStream;
        Properties credentials = new Properties();
        try {
            fileInputStream = new FileInputStream(credentialsFilePath);
            credentials.load(fileInputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return credentials;
    }


    //Getters and setters
    public String getJsonFilePath() {
        return jsonFilePath;
    }
    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
    public Map<String, TestDataSet> getAllTestData() {
        return allTestData;
    }
}
