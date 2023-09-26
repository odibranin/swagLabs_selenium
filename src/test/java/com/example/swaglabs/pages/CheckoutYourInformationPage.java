package com.example.swaglabs.pages;

import com.example.swaglabs.utils.GlobalValues;
import com.example.swaglabs.utils.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutYourInformationPage {
    private final WebDriver driver;
    private WebElement PAGE_HEADER;
    private WebElement SHOPPING_CART_BUTTON;
    private WebElement SECONDARY_HEADER;
    private WebElement FIRSTNAME_FIELD;
    private WebElement LASTNAME_FIELD;
    private WebElement POSTAL_CODE_FIELD;
    private String FIRSTNAME_FIELD_TEXT;
    private String LASTNAME_FIELD_TEXT;
    private String POSTAL_CODE_FIELD_TEXT;
    private WebElement CANCEL_BUTTON;
    private WebElement CONTINUE_BUTTON;

    public CheckoutYourInformationPage(final WebDriver driver) {
        this.driver = driver;
        this.PAGE_HEADER = driver.findElement(By.cssSelector("div.app_logo"));
        this.SHOPPING_CART_BUTTON = driver.findElement(By.id("shopping_cart_container"));
        this.SECONDARY_HEADER = driver.findElement(By.cssSelector("div.subheader"));
        this.FIRSTNAME_FIELD = driver.findElement(By.id("first-name"));
        this.LASTNAME_FIELD = driver.findElement(By.id("last-name"));
        this.POSTAL_CODE_FIELD = driver.findElement(By.id("postal-code"));
        this.FIRSTNAME_FIELD_TEXT = "First Name";
        this.LASTNAME_FIELD_TEXT = "Last Name";
        this.POSTAL_CODE_FIELD_TEXT = "Zip/Postal Code";
        this.CANCEL_BUTTON = driver.findElement(By.cssSelector("div.checkout_buttons > a.cart_cancel_link"));
        this.CONTINUE_BUTTON = driver.findElement(By.cssSelector("div.checkout_buttons > input.btn_primary"));
    }

    public void validatePageContent() {
        final String actualPageUrl = driver.getCurrentUrl();
        String EXPECTED_PAGE_URL = "https://www.saucedemo.com/v1/checkout-step-one.html";
        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, ValidationMessage.VALIDATE_PAGE_URL);

        final boolean isHeaderDisplayed = PAGE_HEADER.isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, ValidationMessage.VALIDATE_HEADER_DISPLAY);

        final String actualSecondaryHeader = SECONDARY_HEADER.getText();
        final String EXPECTED_SECONDARY_HEADER = "Checkout: Your Information";
        Assert.assertEquals(actualSecondaryHeader, EXPECTED_SECONDARY_HEADER, ValidationMessage.VALIDATE_SECONDARY_HEADER);

        final boolean isShoppingCartButtonDisplayed = SHOPPING_CART_BUTTON.isDisplayed();
        Assert.assertTrue(isShoppingCartButtonDisplayed, ValidationMessage.VALIDATE_SHOPPING_CART_BUTTON_IS_DISPLAYED);

        final String actualFirstnameFieldText = FIRSTNAME_FIELD.getAttribute("placeholder");
        Assert.assertEquals(actualFirstnameFieldText, FIRSTNAME_FIELD_TEXT, ValidationMessage.VALIDATE_FIRST_NAME_FIELD_TEXT);

        final String actualLastnameFieldText = LASTNAME_FIELD.getAttribute("placeholder");
        Assert.assertEquals(actualLastnameFieldText, LASTNAME_FIELD_TEXT, ValidationMessage.VALIDATE_LAST_NAME_FIELD_TEXT);

        final String actualPostalCodeFieldText = POSTAL_CODE_FIELD.getAttribute("placeholder");
        Assert.assertEquals(actualPostalCodeFieldText, POSTAL_CODE_FIELD_TEXT, ValidationMessage.VALIDATE_POSTAL_CODE_FIELD_TEXT);
    }

    public void fillInformationForm() {
        FIRSTNAME_FIELD.sendKeys(GlobalValues.FIRSTNAME);
        LASTNAME_FIELD.sendKeys(GlobalValues.LASTNAME);
        POSTAL_CODE_FIELD.sendKeys(GlobalValues.POSTAL_CODE);
    }

    public void clickContinueButton() {
        CONTINUE_BUTTON.click();
    }
}
