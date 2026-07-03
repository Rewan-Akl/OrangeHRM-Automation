package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class AddUserPage extends BasePage {

    // Header
    private final By addUserHeader = By.xpath("//h6[text()='Add User']");

    // User Role Dropdown
    private final By userRoleDropdown =
            By.xpath("(//div[contains(@class,'oxd-select-text')])[1]");
    // Employee Name
    private final By employeeNameInput =
            By.xpath("//input[@placeholder='Type for hints...']");
    // Status
    private final By statusDropdown = By.xpath(
            "//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"
    );
    // Username
    private final By usernameInput = By.xpath(
            "//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );
    // Password
    private final By passwordInput = By.xpath(
            "//label[normalize-space()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );
    // Confirm Password
    private final By confirmPasswordInput = By.xpath(
            "//label[normalize-space()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );
    // Save Button
    private final By saveButton =
            By.xpath("//button[@type='submit' and normalize-space()='Save']");

    // Employee Suggestion
    private By employeeSuggestion(String employeeName) {
        return By.xpath("//div[@role='listbox']//span[normalize-space()='" + employeeName + "']");
    }

    // Constructor
    public AddUserPage() {
        super();
    }

    // Dynamic Locator for Dropdown Options
    private By dropdownOption(String option) {
        return By.xpath("//div[@role='option']//span[normalize-space()='" + option + "']");
    }

    // Validation
    public boolean isAddUserPageDisplayed() {
        return isDisplayed(addUserHeader);
    }

    // Business Method
    public void selectUserRole(String role) {
        click(userRoleDropdown);
        click(dropdownOption(role));
    }

    public void selectEmployeeName(String employeeName) {
        type(employeeNameInput, employeeName);
        click(employeeSuggestion(employeeName));
    }

    public void selectStatus(String status) {
        click(statusDropdown);
        click(dropdownOption(status));
    }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        type(confirmPasswordInput, confirmPassword);
    }

    public void createUser(String role,
                           String employeeName,
                           String status,
                           String username,
                           String password) {

        selectUserRole(role);
        selectEmployeeName(employeeName);
        selectStatus(status);
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(password);
        clickOnSaveButton();
    }

    public void clickOnSaveButton (){
        click(saveButton);
    }

}