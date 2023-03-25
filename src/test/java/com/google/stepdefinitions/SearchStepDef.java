package com.google.stepdefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);

    @Given("User navigates to Google")
    public void user_navigates_to_google() {
        driver.get(ConfigReader.readProperty("googleUrl"));
    }

    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
        googleMainPage.validateHappySearch("CodeFish");
    }

    @Then("User gets more then ten links on the first page")
    public void user_gets_more_then_ten_links_on_the_first_page() {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(10));
    }




    @When("User Searches for Kyrgyz food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
        googleMainPage.validateHappySearch("Kyrgyz food in USA");
    }

    @Then("Validates search results > then 180m")
    public void validates_search_results_then_180m(int number) {
        Assert.assertTrue(googleMainPage.kyrgyzFoodSearch(number));
    }





    @When("User searches for turkish baklava")
    public void user_searches_for_turkish_baklava() {
        googleMainPage.validateHappySearch("Turkish Baklava");
    }

    @Then("User gets result less than one second")
    public void user_gets_result_less_than_one_second() {
        googleMainPage.searchTime();
    }

}
