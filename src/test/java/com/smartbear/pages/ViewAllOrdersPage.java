package com.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class ViewAllOrdersPage {
    public ViewAllOrdersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "View all orders")
    WebElement ViewAllOrdersButton;

    @FindBy  (xpath = "//tr[2]//td")
    List<WebElement> actualListElements;


    public void validationOrder (List<String> listExpected){
        for (int i = 1; i < actualListElements.size()-1; i++) {
            Assert.assertEquals(listExpected.get(i),BrowserUtils.getText(actualListElements.get(i)));
        }

    }


}
