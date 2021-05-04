package ru.training.at.hw1.classes.operations;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class OperationTest {

    public Calculator testCalc = null;

    @BeforeClass(alwaysRun = true)
    public void createCaclulatorObject(){
        testCalc = new Calculator();
    }

    @AfterClass(alwaysRun = true)
    public void nullifyCalculatorObject(){
        testCalc = null;
    }
}
