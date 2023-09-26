package com.example.swaglabs.pages;

import com.example.swaglabs.utils.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final WebElement HAMBURGER_BUTTON;
    private final WebElement PAGE_HEADER;
    private final WebElement SHOPPING_CART_BUTTON;
    private final WebElement SECONDARY_HEADER;
    private final WebElement FILTER_DROPDOWN;
    private final WebElement PRODUCT_RED_TSHIRT;
    private final WebElement RED_TSHIRT_ADD_TO_CART_BUTTON;
    private final WebElement PRODUCT_ONESIE;
    private final WebElement ONESIE_ADD_TO_CART_BUTTON;

    public ProductsPage(final WebDriver driver) {
        this.driver = driver;
        this.HAMBURGER_BUTTON = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
        this.PAGE_HEADER = driver.findElement(By.cssSelector("div.header_label"));
        this.SHOPPING_CART_BUTTON = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']"));
        this.SECONDARY_HEADER = driver.findElement(By.cssSelector("div.product_label"));
        this.FILTER_DROPDOWN = driver.findElement(By.className("product_sort_container"));
        this.PRODUCT_RED_TSHIRT = driver.findElement(By.xpath("//div[@class='inventory_item'][5]"));
        this.RED_TSHIRT_ADD_TO_CART_BUTTON = PRODUCT_RED_TSHIRT.findElement(By.xpath(".//button[@class='btn_primary btn_inventory']"));
        this.PRODUCT_ONESIE = driver.findElement(By.xpath("//div[@class='inventory_item'][6]"));
        this.ONESIE_ADD_TO_CART_BUTTON = PRODUCT_ONESIE.findElement(By.xpath(".//button[@class='btn_primary btn_inventory']"));
    }

    public void validatePageContent() {
        final String actualPageUrl = driver.getCurrentUrl();
        String EXPECTED_PAGE_URL = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, ValidationMessage.VALIDATE_PAGE_URL);

        final boolean isHeaderDisplayed = PAGE_HEADER.isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, ValidationMessage.VALIDATE_HEADER_DISPLAY);

        final String actualSecondaryHeader = SECONDARY_HEADER.getText();
        final String EXPECTED_SECONDARY_HEADER = "Products";
        Assert.assertEquals(actualSecondaryHeader, EXPECTED_SECONDARY_HEADER, ValidationMessage.VALIDATE_SECONDARY_HEADER);

        final boolean isShoppingCartButtonDisplayed = SHOPPING_CART_BUTTON.isDisplayed();
        Assert.assertTrue(isShoppingCartButtonDisplayed, ValidationMessage.VALIDATE_SHOPPING_CART_BUTTON_IS_DISPLAYED);
    }

    public void addItemsToCart() {
        Select dropdown = new Select(FILTER_DROPDOWN);
        dropdown.selectByValue("za");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(RED_TSHIRT_ADD_TO_CART_BUTTON));
        RED_TSHIRT_ADD_TO_CART_BUTTON.click();
        wait.until(ExpectedConditions.elementToBeClickable(ONESIE_ADD_TO_CART_BUTTON));
        ONESIE_ADD_TO_CART_BUTTON.click();
    }

    public void clickOnCartButton() {
        SHOPPING_CART_BUTTON.click();
    }
}





