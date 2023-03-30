package com.smartbear.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/smartbear",//feature files
        glue = "com/smartbear/stepDef", //step definitions
        dryRun = false,//getting snips without executing
        tags = "@regression2",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"})

public class SmartBearRunners {
}
