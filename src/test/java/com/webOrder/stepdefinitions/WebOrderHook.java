package com.webOrder.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderHook {
    WebDriver driver = DriverHelper.getDriver();
    @Before //from cucumber
    public void setup (){
        driver.get(ConfigReader.readProperty("weborderurl"));
    }
    @After //from cucumber
    public void teardown () {
        driver.quit();
    }
}
