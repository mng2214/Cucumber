package com.luma.lumaPages;

import io.cucumber.java.zh_cn.假如;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
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



    public void chooseJacket(String jacketName) throws InterruptedException {
        for (WebElement jacket : listOfProducts) {
            if (BrowserUtils.getText(jacket).contains(jacketName)) {
                jacket.click();
                Thread.sleep(1000);
                sizeM.click();
                colorRed.click();
                addToCartButton.click();
            }
        }

    }



    @FindBy (xpath = "//div[contains(text(),'added Montana Wind Jacket')]")
    WebElement addedToCardMessage;

    public void purchaseValidation (String expectedMsg){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement m =  driver.findElement(By.xpath("//div[contains(text(),'added Montana Wind Jacket')]"));
        m = wait.until((ExpectedConditions.visibilityOf(m)));
        Assert.assertTrue(BrowserUtils.getText(m).contains(expectedMsg));
    }

}
