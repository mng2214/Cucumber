package com.luma.lumaSteDef;

import com.luma.lumaPages.LumaMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LumaStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LumaMainPage lumaMainPage = new LumaMainPage(driver);

    @When("User select Men-Tops-Jackets")
    public void user_select_men_tops_jackets() {
        lumaMainPage.chooseJackets();
    }

    @When("User select to cart {string}")
    public void user_select_to_cart(String jacketName) {
        lumaMainPage.chooseJacket(jacketName);
    }

    @Then("User validates {string}")
    public void user_validates(String addedToCartMessage) {
        lumaMainPage.purchaseValidation(addedToCartMessage);
    }


}
