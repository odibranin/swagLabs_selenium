package com.example.swaglabs.pages;

import com.example.swaglabs.utils.GlobalValues;
import com.example.swaglabs.utils.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;
    private WebElement LOGIN_HEADER;
    private WebElement USERNAME_FIELD;
    private WebElement PASSWORD_FIELD;
    private WebElement LOGIN_BUTTON;
    private WebElement LOGIN_FORM;
    private WebElement LOGO_IMAGE;

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
        this.LOGIN_HEADER = driver.findElement(By.cssSelector("div.login_logo"));
        this.USERNAME_FIELD = driver.findElement((By.id("user-name")));
        this.PASSWORD_FIELD = driver.findElement(By.id("password"));
        this.LOGIN_BUTTON = driver.findElement(By.id("login-button"));
        this.LOGIN_FORM = driver.findElement(By.id("login_button_container"));
        this.LOGO_IMAGE = driver.findElement(By.cssSelector("img.bot_column"));
    }

    public void validatePageContent() {
        final boolean isHeaderDisplayed = LOGIN_HEADER.isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, ValidationMessage.VALIDATE_HEADER_DISPLAY);

        final String actualPageUrl = driver.getCurrentUrl();
        String EXPECTED_PAGE_URL = "https://www.saucedemo.com/v1/index.html";
        Assert.assertEquals(actualPageUrl, EXPECTED_PAGE_URL, ValidationMessage.VALIDATE_HEADER );

        final boolean isLoginFormDisplayed = LOGIN_FORM.isDisplayed();
        Assert.assertTrue(isLoginFormDisplayed, ValidationMessage.VALIDATE_LOGIN_FORM);

        final boolean isUsernameFieldDisplayed = USERNAME_FIELD.isDisplayed();
        Assert.assertTrue(isUsernameFieldDisplayed, ValidationMessage.VALIDATE_USERNAME_FIELD);

        final boolean isPasswordFieldDisplayed = PASSWORD_FIELD.isDisplayed();
        Assert.assertTrue(isPasswordFieldDisplayed, ValidationMessage.VALIDATE_PASSWORD_FIELD);

        final boolean isLogoImageDisplayed = LOGO_IMAGE.isDisplayed();
        Assert.assertTrue(isLogoImageDisplayed, ValidationMessage.VALIDATE_LOGIN_IMAGE);
    }

    public void fillLoginForm() {
       USERNAME_FIELD.sendKeys(GlobalValues.VALID_USERNAME);
       PASSWORD_FIELD.sendKeys(GlobalValues.VALID_PASSWORD);
    }

    public void clickSubmitButton() {
        LOGIN_BUTTON.click();
    }
}
