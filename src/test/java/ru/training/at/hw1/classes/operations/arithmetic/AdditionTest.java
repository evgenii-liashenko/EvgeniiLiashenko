package ru.training.at.hw1.classes.operations.arithmetic;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import ru.training.at.hw1.classes.operations.OperationTest;

public class AdditionTest extends OperationTest {
    @Test(groups = {"arithmeticOperations", "plusMinus"},
            dataProvider = "operands", dataProviderClass = DataProvider.class)
    public void testSum(int a, int b) {
        int expectedResult = a + b;
        long actualResult = testCalc.sum((long) a, (long) b);
        assertEquals(actualResult, (long) expectedResult);
    }
}
