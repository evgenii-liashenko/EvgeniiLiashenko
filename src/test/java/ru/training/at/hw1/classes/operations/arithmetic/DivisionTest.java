package ru.training.at.hw1.classes.operations.arithmetic;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import ru.training.at.hw1.classes.operations.OperationTest;

public class DivisionTest extends OperationTest {
    @Test(groups = {"arithmeticOperations", "multiplyDivide"},
            dataProvider = "operands", dataProviderClass = DataProvider.class)
    public void testDiv(int a, int b) {
        int expectedResult = a / b;
        long actualResult = testCalc.div((long) a, (long) b);
        assertEquals(actualResult, (long) expectedResult);
    }
}
