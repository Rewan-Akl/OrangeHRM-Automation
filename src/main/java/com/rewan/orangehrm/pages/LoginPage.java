package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By loginHeader = By.xpath("//h5[normalize-space()='Login']");

    // Private Actions
    private void enterUsername(String username) {
        type(userNameField, username);
    }

    private void enterPassword(String password) {
        type(passwordField, password);
    }

    private void clickLogin() {
        click(loginButton);
    }

    // Business Method
    public DashboardPage login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        return new DashboardPage();
    }
    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginHeader);
    }

}
