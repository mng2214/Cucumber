package com.google.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name ='q']")
    WebElement searchBar;

    @FindBy(xpath = "//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id ='result-stats']")
    WebElement searchResult;

    @FindBy(xpath = "//div[@id='result-stats']//nobr")
    WebElement searchTime;


    public void validateHappySearch(String text) {
        searchBar.sendKeys(text, Keys.ENTER);
    }

    public boolean validateNumberOfLinks(int number) {
        return (allLinks.size() > number);

    }

    public boolean kyrgyzFoodSearch(int numberOfLinks) {
        String[] searchWords = BrowserUtils.getText(searchResult).split(" ");
        String str = searchWords[1].replace(",","");
        return Integer.parseInt(str)>numberOfLinks;
       // return (searchWords[1].replace(",","").equals("181000000"));
    }

    public boolean searchTime (){
        String[] arr = BrowserUtils.getText(searchTime).split(" ");
        return Double.parseDouble(arr[0].substring(1))<1.0;
    }



}
