package com.example.swaglabs.pages;

import com.example.swaglabs.utils.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FinishPage {
    private final WebDriver driver;
    private WebElement HAMBURGER_BUTTON;
    private WebElement LOGOUT;
    private WebElement PAGE_HEADER;
    private WebElement SHOPPING_CART_BUTTON;
    private WebElement SECONDARY_HEADER;
    private WebElement CHECKOUT_COMPLETE_HEADER;

    public FinishPage(final WebDriver driver) {
        this.driver = driver;
        this.HAMBURGER_BUTTON = driver.findElement(By.cssSelector("div.bm-burger-button"));
        this.LOGOUT = driver.findElement(By.id("logout_sidebar_link"));
        this.PAGE_HEADER = driver.findElement(By.cssSelector("div.app_logo"));
        this.SHOPPING_CART_BUTTON = driver.findElement(By.id("shopping_cart_container"));
        this.SECONDARY_HEADER = driver.findElement(By.cssSelector("div.subheader"));
        this.CHECKOUT_COMPLETE_HEADER = driver.findElement(By.id("checkout_complete_container"));
    }

    public void validatePageContent() {
        final String actualPageUrl = driver.getCurrentUrl();
        String EXPECTED_PAGE_URL = "https://www.saucedemo.com/v1/checkout-complete.html";
        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, ValidationMessage.VALIDATE_PAGE_URL);

        final boolean isHeaderDisplayed = PAGE_HEADER.isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, ValidationMessage.VALIDATE_HEADER_DISPLAY);

        final String actualSecondaryHeader = SECONDARY_HEADER.getText();
        final String EXPECTED_SECONDARY_HEADER = "Finish";
        Assert.assertEquals(actualSecondaryHeader, EXPECTED_SECONDARY_HEADER, ValidationMessage.VALIDATE_SECONDARY_HEADER);

        final boolean isShoppingCartButtonDisplayed = SHOPPING_CART_BUTTON.isDisplayed();
        Assert.assertTrue(isShoppingCartButtonDisplayed, ValidationMessage.VALIDATE_SHOPPING_CART_BUTTON_IS_DISPLAYED);

        final String actualCheckoutCompleteHeader = CHECKOUT_COMPLETE_HEADER.getText();
        final String EXPECTED_CHECKOUT_HEADER = "THANK YOU FOR YOUR ORDER\n" +
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(actualCheckoutCompleteHeader, EXPECTED_CHECKOUT_HEADER, ValidationMessage.VALIDATE_CHECKOUT_HEADER);
    }

    public void logOut() {
        HAMBURGER_BUTTON.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT));
        LOGOUT.click();
    }
}
