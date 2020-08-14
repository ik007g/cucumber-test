package com.cucumber.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)// JUnit run my tests w/ Cucumber-cucumber will be triggered here
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
//                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "pretty"},
        features = "src/test/resources/features",
        glue = "com/cucumber/library/step_definitions",
        dryRun = false,
        tags = "@hw"

)

public class CukesRunner {
}

