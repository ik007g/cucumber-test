package com.cucumber.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/rerun-cucumber-reports",
        glue = "com/cucumber/library/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
