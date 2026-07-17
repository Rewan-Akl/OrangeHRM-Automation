package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class AdminPage extends BasePage {

    private final By adminHeader = By.xpath("//h6[text()='Admin']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");

    public boolean isAdminPageDisplayed() {
        return isDisplayed(adminHeader);
    }

    public AddUserPage clickOnAddButton() {
        click(addButton);
        return new AddUserPage();
    }
}