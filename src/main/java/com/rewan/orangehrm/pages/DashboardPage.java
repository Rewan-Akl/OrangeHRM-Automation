package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import com.rewan.orangehrm.components.HeaderComponent;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private final By dashboardHeader =
            By.xpath("//h6[text()='Dashboard']");

    private final By adminMenu = By.xpath("//span[text()='Admin']");

    private final HeaderComponent header = new HeaderComponent();

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }

    public AdminPage openAdminPage() {
        click(adminMenu);
        return new AdminPage();
    }

    public LoginPage logout() {
        return header.logout();
    }

}