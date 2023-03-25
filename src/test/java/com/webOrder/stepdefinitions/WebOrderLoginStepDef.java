package com.webOrder.stepdefinitions;

import com.webOrder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderLoginStepDef {

    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);

    @When("User provides {string} and {string} for WebOrder")
    public void user_provides_and_for_web_order(String username, String password) {
        webOrderLoginPage.WebOrderLogin(username, password);
    }

    @Then("User validates {string} from homepage")
    public void user_validates_from_homepage(String title) {
        Assert.assertEquals(title,webOrderLoginPage.webOrderTitle(driver));
    }

    @Then("User validates message {string}")
    public void user_validates_message(String errorMessage) {
        Assert.assertTrue(errorMessage.contains(webOrderLoginPage.errorMsg()));
    }
}
