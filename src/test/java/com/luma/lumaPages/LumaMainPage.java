package com.luma.lumaPages;

import io.cucumber.java.zh_cn.假如;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LumaMainPage {
    WebDriver driver;

    public LumaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='store.menu']//span[.='Men']")
    WebElement menOption;
    @FindBy(xpath = "//li[@class='item']//a[.='Jackets']")
    WebElement jackets;

    public void chooseJackets() {
        menOption.click();
        jackets.click();
    }

    @FindBy(xpath = "//div[@class='column main']//a[@class='product-item-link']")
    List<WebElement> listOfProducts;

    @FindBy(xpath = "//div[@option-label='M']")
    WebElement sizeM;
    @FindBy(xpath = "//div[@option-label='Red']")
    WebElement colorRed;

    @FindBy(css = "#product-addtocart-button")
    WebElement addToCartButton;

    public void chooseJacket(String jacketName) {
        for (WebElement jacket : listOfProducts) {
            if (BrowserUtils.getText(jacket).equals(jacketName)) {
                jacket.click();
                break;
            }
        }
        sizeM.click();
        colorRed.click();
        addToCartButton.click();
    }

    @FindBy (xpath = "//div[contains(text(),'added Montana Wind Jacket')]")
    WebElement addedToCardMessage;

    public void purchaseValidation (String expectedMsg){

        Assert.assertTrue(BrowserUtils.getText(addedToCardMessage).contains(expectedMsg));
    }

}
