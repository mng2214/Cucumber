package com.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.sql.Driver;

public class MainPageSmartBear {

    public MainPageSmartBear(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productSelect;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;

    @FindBy(xpath = "//input[@value='Visa']")
    WebElement visa;
    @FindBy(xpath = "//input[@value='MasterCard']")
    WebElement masterCard;
    @FindBy(xpath = "//input[@value='American Express']")
    WebElement americanExpress;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expDate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;


    public void productInfoEnter(String product, String quantity) {
        BrowserUtils.selectBy(productSelect, product, "text");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void addressInfoEnter(String customerName, String street, String city, String state, String zip) {
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
    }

    public void cardChooser(String cardType) {
        switch (cardType.toLowerCase()) {
            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "americanexpress":
                americanExpress.click();
                break;
            default:
                System.out.println("please enter Visa , MasterCard or AmericanExpress");
        }
    }

    public void paymentInfoEnter(String cardType, String cardNumber, String expDate) {
        cardChooser(cardType);
        this.cardNumber.sendKeys(cardNumber);
        this.expDate.sendKeys(expDate);
        processButton.click();
    }

    public void validationSuccessfullyAdded(String message) {
        Assert.assertTrue(BrowserUtils.getText(this.message).contains(message));
    }

}
