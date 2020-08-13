package com.cucumber.library.step_definitions;

import com.cucumber.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order=0)
    public void setUpScenario(){
        System.out.println("Set up browser");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Driver.getDriver().manage().window().fullscreen();

    }

    @Before(value = "@db", order = 1)
//    @Before("@db")
    public void connect(){
        System.out.println("Connecting to db");
    }

    @After
    public void tearDownScenario(Scenario scenario){
//        System.out.println("scenario.getSourceTagNames() = "+scenario.getSourceTagNames());
//        System.out.println("scenario.getName() = "+scenario.getName());
        scenario.write("Complete scenario: "+scenario.getName());
        if(scenario.isFailed()){
            //take screenshot using Se
           final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            //attach to report
            scenario.embed(screenshot,"image/png",scenario.getName());
        }

        Driver.closeDriver();
    }

    @After("@db")
    public void closeConnection()
    {
        System.out.println("Closing connection to db");
    }

}
