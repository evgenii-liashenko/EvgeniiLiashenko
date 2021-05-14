package ru.training.at.hw3.tests;

import org.testng.annotations.DataProvider;

public class UserData {
    @DataProvider(name = "credentials")
    public Object[][] dpMethod() {
        return new Object[][]{{"Roman", "Jdi1234"}};
    }

}
