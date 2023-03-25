package com.google.stepdefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchParametersStepDef {
    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);

    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
        driver.get(url);
    }

    @When("User searches for {string}")
    public void user_searches_for(String text) {
        googleMainPage.validateHappySearch(text);
    }

    @Then("User gets more then {int} links")
    public void user_gets_more_then_links(int link) {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(link));
    }

    @Then("User validates the result is more then  {int}")
    public void user_validates_the_result_is_more_then(Integer number) {
        Assert.assertTrue(googleMainPage.kyrgyzFoodSearch(number));
    }


}
