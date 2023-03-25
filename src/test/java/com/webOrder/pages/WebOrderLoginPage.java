package com.webOrder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage  {

    public WebOrderLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email")
    WebElement username;

    @FindBy(css = "#Password")
    WebElement password;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Sign in Failed')]")
    WebElement errorMessage;



    public void WebOrderLogin(String username, String password) {
        this.username.clear();
        this.password.clear();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String webOrderTitle(WebDriver driver){
        return driver.getTitle();
    }
    public String errorMsg () {
        return BrowserUtils.getText(errorMessage);
    }

}
