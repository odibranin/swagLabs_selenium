package com.example.swaglabs.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {
    public static WebDriver getWebDriver(String browserName) {
        WebDriver driver = switch (browserName.toLowerCase()) {
            case "chrome" -> getChromeDriver();
            case "firefox" -> getFirefoxDriver();
            case "edge" -> getEdgeDriver();
            default -> throw new IllegalArgumentException(ErrorMessage.BROWSER_NOT_FOUND
                    + browserName);
        };
        configureDriver(driver);
        return driver;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get(GlobalValues.LOGIN_URL);

    }
}
