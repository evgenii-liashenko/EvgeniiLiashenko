package ru.training.at.hw1.classes.operations.arithmetic;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "operands")
    public Object[][] dpMethod() {
        return new Object[][]{{1, 6}, {-2, 4}};
    }
}
