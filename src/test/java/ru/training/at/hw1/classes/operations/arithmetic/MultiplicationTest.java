package ru.training.at.hw1.classes.operations.arithmetic;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest {
    @Test(groups = {"arithmeticOperations", "multiplyDivide"},
            dataProvider = "operands", dataProviderClass = DataProvider.class)
    public void testMult(int a, int b) {
        Calculator testCalc = new Calculator();
        int expectedResult = a * b;
        long actualResult = testCalc.mult((long) a, (long) b);
        Assert.assertEquals(actualResult, (long) expectedResult);
    }
}
