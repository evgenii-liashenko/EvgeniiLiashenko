package ru.training.at.hw1.classes.operations.arithmetic;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import ru.training.at.hw1.classes.operations.OperationTest;

public class SubtractionTest extends OperationTest {
    @Test(groups = {"arithmeticOperations", "plusMinus"},
            dataProvider = "operands", dataProviderClass = DataProvider.class)
    public void testSub(int a, int b) {
        int expectedResult = a - b;
        long actualResult = testCalc.sub((long) a, (long) b);
        assertEquals(actualResult, (long) expectedResult);
    }
}
