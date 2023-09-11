package com.example.swaglabs.pages;

import com.example.swaglabs.utils.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutOverviewPage {
    private WebDriver driver;
    private final WebElement HAMBURGER_BUTTON;
    private final WebElement PAGE_HEADER;
    private final WebElement SHOPPING_CART_BUTTON;
    private final WebElement SECONDARY_HEADER;
    private final WebElement CANCEL_BUTTON;
    private final WebElement FINISH_BUTTON;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.HAMBURGER_BUTTON = driver.findElement(By.cssSelector("div.bm-burger-button"));
        this.PAGE_HEADER = driver.findElement(By.cssSelector("div.app_logo"));
        this.SHOPPING_CART_BUTTON = driver.findElement(By.id("shopping_cart_container"));
        this.SECONDARY_HEADER = driver.findElement(By.cssSelector("div.subheader"));
        this.CANCEL_BUTTON = driver.findElement(By.cssSelector("div.cart_footer > a.cart_cancel_link"));
        this.FINISH_BUTTON = driver.findElement(By.cssSelector("a.btn_action.cart_button[href='./checkout-complete.html']"));
    }

    public void validatePageContent() {
        final String actualPageUrl = driver.getCurrentUrl();
        String EXPECTED_PAGE_URL = "https://www.saucedemo.com/v1/checkout-step-two.html";
        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, ValidationMessage.VALIDATE_PAGE_URL);

        final boolean isHeaderDisplayed = PAGE_HEADER.isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, ValidationMessage.VALIDATE_HEADER_DISPLAY);

        final boolean isHamburgerButtonDisplayed = HAMBURGER_BUTTON.isDisplayed();
        Assert.assertTrue(isHamburgerButtonDisplayed, ValidationMessage.VALIDATE_HAMBURGER_BUTTON);

        final String actualSecondaryHeader = SECONDARY_HEADER.getText();
        final String EXPECTED_SECONDARY_HEADER = "Checkout: Overview";
        Assert.assertEquals(actualSecondaryHeader, EXPECTED_SECONDARY_HEADER, ValidationMessage.VALIDATE_SECONDARY_HEADER);

        final boolean isShoppingCartButtonDisplayed = SHOPPING_CART_BUTTON.isDisplayed();
        Assert.assertTrue(isShoppingCartButtonDisplayed, ValidationMessage.VALIDATE_SHOPPING_CART_BUTTON_IS_DISPLAYED);
    }

    public void clickCancelButton() {
        CANCEL_BUTTON.click();
    }

    public void clickFinishButton() {
        FINISH_BUTTON.click();
    }

}

