package com.example.swaglabs.tests;

import com.example.swaglabs.pages.*;
import com.example.swaglabs.utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private FinishPage finishPage;

    @Parameters("browser")
    @BeforeMethod()
    public void setUp(final String browser) {
        this.driver = WebDriverSetup.getWebDriver(browser);
        this.loginPage = new LoginPage(driver);

        //Validate Login page content
        loginPage.validatePageContent();

        //Log in with valid credentials
        loginPage.fillLoginForm();

        //Click on the "Login" button
        loginPage.clickSubmitButton();
    }

    @Test
    public void completeOrder() {
        this.productsPage = new ProductsPage(driver);
        //Validate "Products" page content
        productsPage.validatePageContent();

        //Add products to cart
        productsPage.addItemsToCart();

        //Click on "Cart" button
        productsPage.clickOnCartButton();

        this.yourCartPage = new YourCartPage(driver);
        //Validate "Your Cart" page content
        yourCartPage.validatePageContent();

        //Click on the "Checkout" button
        yourCartPage.clickCheckoutButton();

        this.checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        //Validate "Checkout:Your Information" page content
        checkoutYourInformationPage.validatePageContent();

        //Fill the checkout information form
        checkoutYourInformationPage.fillInformationForm();

        //Click on "Continue" button
        checkoutYourInformationPage.clickContinueButton();

        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        //Validate "Checkout:Overview" page content
        checkoutOverviewPage.validatePageContent();

        //Click on "Finish" button
        checkoutOverviewPage.clickFinishButton();

        this.finishPage = new FinishPage(driver);
        //Validate "Finish" page content
        finishPage.validatePageContent();

        //Logout
        finishPage.logOut();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.close();
    }
}
