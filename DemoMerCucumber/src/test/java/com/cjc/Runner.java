package com.cjc;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/Features",
glue="com.cjc.mt.step",tags="@Test1,@Test2", format= {"pretty","html:test-output"},
monochrome=true, dryRun =false
)
public class Runner 
{

}