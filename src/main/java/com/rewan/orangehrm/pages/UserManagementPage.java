package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class UserManagementPage extends BasePage {

    private final By usernameSearchInput = By.xpath(
            "//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input"
    );

    private final By searchButton =
            By.xpath("//button[normalize-space()='Search']");

    private By usernameInTable(String username) {
        return By.xpath("//*[normalize-space()='" + username + "']");
    }

    public void searchByUsername(String username){
        type(usernameSearchInput, username);
        click(searchButton);
    }
    public boolean isUserDisplayed(String username) {
        return isDisplayed(usernameInTable(username));
    }
}
