package ru.training.at.hw1.classes.operations.arithmetic;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTest {

    @Test(groups = {"arithmeticOperations", "plusMinus"},
            dataProvider = "operands", dataProviderClass = DataProvider.class)
    public void testSub(int a, int b) {
        Calculator testCalc = new Calculator();
        int expectedResult = a - b;
        long actualResult = testCalc.sub((long) a, (long) b);
        Assert.assertEquals(actualResult, (long) expectedResult);
    }
}
