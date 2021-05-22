package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = {"src/test/resources/cucumber.features"})
public class CucumberTestLauncher extends AbstractTestNGCucumberTests {


}
