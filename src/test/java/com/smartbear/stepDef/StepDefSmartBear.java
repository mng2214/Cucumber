package com.smartbear.stepDef;

import com.smartbear.pages.LoginPageSmartBear;
import com.smartbear.pages.MainPageSmartBear;
import com.smartbear.pages.ViewAllOrdersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


    @When("User goes to View All Order page and validates added product: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string}")
    public void userGoesToViewAllOrderPageAndValidatesAddedProductNameProductDateQuantityAddressCityStateCartTypeCardNumberExpDate(String name, String product, String quantity, String address, String city, String state, String zip, String cartType, String cardNumber, String expDate) {
        List<String> list = Arrays.asList("", name, product, quantity, viewAllOrdersPage.dateCorrector(), address, city, state, zip, cartType, cardNumber, expDate, "");
        viewAllOrdersPage.validationOrder(list);
    }


    @When("User login with  username  and passwod  and click order button and click Order Page")
    public void user_login_with_username_and_passwod_and_click_order_button_and_click_order_page(DataTable dataTable) {
        Map<String, String> loginInfo = dataTable.asMap();
        loginPageSmartBear.loginToSmartBearAndClickOrder(loginInfo.get("username"), loginInfo.get("password"));
    }

    @When("User provides Product Info")
    public void user_provides_product_info(DataTable dataTable) {
        Map<String, String> productInfo = dataTable.asMap();
        mainPageSmartBear.productInfoEnter(productInfo.get("product"), productInfo.get("quantity"));
    }

    @When("User provides Personal Info")
    public void user_provides_personal_info(DataTable dataTable) {
        Map<String, String> personalInfo = dataTable.asMap();
        mainPageSmartBear.addressInfoEnter(personalInfo.get("name"), personalInfo.get("address"), personalInfo.get("city"), personalInfo.get("state"), personalInfo.get("zip"));
    }

    @When("User provides Payment Info")
    public void user_provides_payment_info(DataTable dataTable) {
        Map<String, String> paymentInfo = dataTable.asMap();
        mainPageSmartBear.paymentInfoEnter(paymentInfo.get("cartType"), paymentInfo.get("cardNumber"), paymentInfo.get("expDate"));
    }

    @When("User click Process and Validates message")
    public void user_click_process_and_validates_message(DataTable dataTable) {
        List<String> listMessage = dataTable.asList();
        mainPageSmartBear.validationSuccessfullyAdded(listMessage.get(0));
    }

}
