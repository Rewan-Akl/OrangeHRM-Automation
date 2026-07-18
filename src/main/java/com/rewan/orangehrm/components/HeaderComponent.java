package com.rewan.orangehrm.components;

import com.rewan.orangehrm.base.BasePage;
import com.rewan.orangehrm.pages.LoginPage;
import org.openqa.selenium.By;

public class HeaderComponent extends BasePage {

    public HeaderComponent() {
        super();
    }

    private final By profileMenu =
            By.className("oxd-userdropdown-name");

    private final By logoutButton =
            By.xpath("//a[normalize-space()='Logout']");

    public void openProfileMenu() {
        click(profileMenu);
    }

    public LoginPage logout() {
        openProfileMenu();
        click(logoutButton);
        return new LoginPage();
    }
}