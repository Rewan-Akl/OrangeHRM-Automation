package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class TimePage extends BasePage {

    // Locators
    private final By employeeNameField =
            By.xpath("//input[@placeholder='Type for hints...']");

    private final By employeeSuggestion =
            By.xpath("//div[@role='listbox']//span[normalize-space()='Orange Test']");

    private final By viewButton =
            By.xpath("//button[normalize-space()='View']");

    // Business Methods
    public void searchEmployee(String employeeHint, String employeeName) {
        type(employeeNameField, employeeHint);
        click(employeeSuggestion);
    }

    public EmployeeTimesheetPage clickOnViewButton() {
        click(viewButton);
        return new EmployeeTimesheetPage();
    }
}