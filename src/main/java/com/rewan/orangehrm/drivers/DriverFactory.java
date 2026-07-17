package com.rewan.orangehrm.drivers;

import com.rewan.orangehrm.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
        // Prevent instantiation
    }

    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            case "edge":

                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();

        getDriver().get(ConfigReader.getProperty("base.url"));

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }

    }

}