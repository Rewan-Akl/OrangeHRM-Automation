package com.rewan.orangehrm.base;

import com.rewan.orangehrm.drivers.DriverFactory;
import com.rewan.orangehrm.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverFactory.getDriver();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Long.parseLong(ConfigReader.getProperty("explicit.wait"))
                )
        );
    }
}