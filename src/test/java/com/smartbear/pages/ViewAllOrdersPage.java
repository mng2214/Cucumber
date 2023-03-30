package com.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @FindBy (xpath = "//tr[2]//td[5]")
    WebElement dateCurrent;

    public void validationOrder (List<String> listExpected){
        ViewAllOrdersButton.click();
        for (int i = 1; i < actualListElements.size()-1; i++) {
            Assert.assertEquals(listExpected.get(i),BrowserUtils.getText(actualListElements.get(i)));
        }
    }

    public String dateCorrector () {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return (currentDate.format(formatter));
    }


}
