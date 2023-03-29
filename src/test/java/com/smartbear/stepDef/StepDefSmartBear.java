package com.smartbear.stepDef;

import com.smartbear.pages.LoginPageSmartBear;
import com.smartbear.pages.MainPageSmartBear;
import com.smartbear.pages.ViewAllOrdersPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.Arrays;
import java.util.List;

public class StepDefSmartBear {
    WebDriver driver = DriverHelper.getDriver();
    LoginPageSmartBear loginPageSmartBear = new LoginPageSmartBear(driver);
    MainPageSmartBear mainPageSmartBear = new MainPageSmartBear(driver);
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage(driver);

    @When("User login with  username {string} and passwod {string} and click order button and click Order Page")
    public void user_login_with_username_and_passwod_and_click_order_button_and_click_order_page(String username, String password) {
        loginPageSmartBear.loginToSmartBearAndClickOrder(username, password);
    }

    @When("User provides Product Info :  {string} , {string},")
    public void user_provides_product_info(String product, String quantity) {
        mainPageSmartBear.productInfoEnter(product, quantity);
    }

    @When("User provides Personal Info : {string}, {string},{string},{string},{string},")
    public void user_provides_personal_info(String name, String street, String city, String state, String zip) {
        mainPageSmartBear.addressInfoEnter(name, street, city, state, zip);
    }

    @When("User provides Payment Info {string}, {string} , {string}")
    public void user_provides_payment_info(String cardType, String cardNumber, String expDate) {
        mainPageSmartBear.paymentInfoEnter(cardType, cardNumber, expDate);
    }

    @When("User click Process and Validates {string}")
    public void user_click_process_and_validates(String message) {
        mainPageSmartBear.validationSuccessfullyAdded(message);
    }


    @When("User goes to View All Order page and validates added product: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string}")
    public void userGoesToViewAllOrderPageAndValidatesAddedProductNameProductDateQuantityAddressCityStateCartTypeCardNumberExpDate(String name, String product, String date,
                                                                                                                                   String quantity, String address, String city,
                                                                                                                                   String state, String zip, String cartType, String cardNumber,
                                                                                                                                   String Date) {
       // String todayDate = viewAllOrdersPage.dateCorrector();
        List<String> list = Arrays.asList("", name, product, date, quantity, address, city, state, zip, cartType, cardNumber, Date, "");
        viewAllOrdersPage.validationOrder(list);
    }
}
