package com.example.swaglabs.pages;

import com.example.swaglabs.utils.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class YourCartPage {
    private WebDriver driver;
    private WebElement PAGE_HEADER;
    private WebElement SHOPPING_CART_BUTTON;
    private WebElement SHOPPING_CART_BUTTON_VALUE;
    private WebElement SECONDARY_HEADER;
    private WebElement CART_QUANTITY_LABEL;
    private WebElement CART_DESCRIPTION_LABEL;
    List<WebElement> CART_ITEMS;
    private WebElement CONTINUE_SHOPPING_BUTTON;
    private WebElement CHECKOUT_BUTTON;

    public YourCartPage(final WebDriver driver) {
        this.driver = driver;
        this.PAGE_HEADER = driver.findElement(By.cssSelector("div.header_label"));
        this.SHOPPING_CART_BUTTON = driver.findElement(By.id("shopping_cart_container"));
        this.SHOPPING_CART_BUTTON_VALUE = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        this.SECONDARY_HEADER = driver.findElement(By.cssSelector("div.subheader"));
        this.CART_QUANTITY_LABEL = driver.findElement(By.cssSelector("div.cart_list > div.cart_quantity_label"));
        this.CART_DESCRIPTION_LABEL = driver.findElement(By.cssSelector("div.cart_list > div.cart_desc_label"));
        this.CART_ITEMS = driver.findElements(By.cssSelector("div.cart_item"));
        this.CONTINUE_SHOPPING_BUTTON = driver.findElement(By.cssSelector("div.cart_footer > a.btn_secondary"));
        this.CHECKOUT_BUTTON = driver.findElement(By.cssSelector("div.cart_footer > a.checkout_button"));
    }

    public void validatePageContent() {
        final String actualPageUrl = driver.getCurrentUrl();
        String EXPECTED_PAGE_URL = "https://www.saucedemo.com/v1/cart.html";
        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, ValidationMessage.VALIDATE_PAGE_URL);

        final boolean isHeaderDisplayed = PAGE_HEADER.isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, ValidationMessage.VALIDATE_HEADER_DISPLAY);

        final boolean isShoppingCartButtonDisplayed = SHOPPING_CART_BUTTON.isDisplayed();
        Assert.assertTrue(isShoppingCartButtonDisplayed, ValidationMessage.VALIDATE_SHOPPING_CART_BUTTON_IS_DISPLAYED);

        final String actualSecondaryHeader = SECONDARY_HEADER.getText();
        final String EXPECTED_SECONDARY_HEADER = "Your Cart";
        Assert.assertEquals(actualSecondaryHeader, EXPECTED_SECONDARY_HEADER, ValidationMessage.VALIDATE_SECONDARY_HEADER);

        final String actualCartQuantityLabel = CART_QUANTITY_LABEL.getText();
        final String expectedCartQuantityLabel = "QTY";
        Assert.assertEquals(actualCartQuantityLabel, expectedCartQuantityLabel, ValidationMessage.VALIDATE_CART_QUANTITY_HEADER);

        final String actualCartDescriptionLabel = CART_DESCRIPTION_LABEL.getText();
        final String expectedCartDescriptionLabel = "DESCRIPTION";
        Assert.assertEquals(actualCartDescriptionLabel, expectedCartDescriptionLabel, ValidationMessage.VALIDATE_CART_DESCRIPTION_HEADER);
    }

    public void clickCheckoutButton() {
        CHECKOUT_BUTTON.click();
    }
}


