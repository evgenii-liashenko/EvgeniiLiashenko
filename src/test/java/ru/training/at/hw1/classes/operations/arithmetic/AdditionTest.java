package ru.training.at.hw1.classes.operations.arithmetic;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionTest {
    @Test(groups = {"arithmeticOperations", "plusMinus"},
            dataProvider = "operands", dataProviderClass = DataProvider.class)
    public void testSum(int a, int b) {
        Calculator testCalc = new Calculator();
        int expectedResult = a + b;
        long actualResult = testCalc.sum((long) a, (long) b);
        Assert.assertEquals(actualResult, (long) expectedResult);
    }
}
