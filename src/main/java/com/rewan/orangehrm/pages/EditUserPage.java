package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import com.rewan.orangehrm.components.HeaderComponent;
import org.openqa.selenium.By;

public class EditUserPage extends BasePage {

    private final By statusDropdown =
            By.xpath("//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");

    private final By disabledOption =
            By.xpath("//div[@role='listbox']//span[normalize-space()='Disabled']");

    private final By saveButton =
            By.xpath("//button[normalize-space()='Save']");

    private final HeaderComponent header = new HeaderComponent();

    public void disableEmployee() {
        click(statusDropdown);
        click(disabledOption);
    }

    public void clickOnSaveButton() {
        click(saveButton);
    }

    public LoginPage logout() {
        return header.logout();
    }
}