package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By loginHeader = By.xpath("//h5[normalize-space()='Login']");
    private final By invalidCredentialsMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    private final By accountDisabledMessage = By.xpath("//p[normalize-space()='Account disabled']");

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

    public String getLoginErrorMessage() {
        return getText(invalidCredentialsMessage);
    }

    public boolean isAccountDisabledMessageDisplayed() {
        return isDisplayed(accountDisabledMessage);
    }

    public String getAccountDisabledMessage() {
        return getText(accountDisabledMessage);
    }

}
