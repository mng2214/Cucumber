package com.smartbear.pages;

import org.junit.After;
import org.junit.runner.manipulation.Ordering;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSmartBear {

    public LoginPageSmartBear (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "#ctl00_MainContent_username")
    WebElement username;
    @FindBy (css = "#ctl00_MainContent_password")
    WebElement password;
    @FindBy (css = "#ctl00_MainContent_login_button")
    WebElement loginButton;

    @FindBy(xpath = "//a[.='Order']")
    WebElement orderPage;

    public void loginToSmartBearAndClickOrder (String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        orderPage.click();
    }


}
