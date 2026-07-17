package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private final By dashboardHeader =
            By.xpath("//h6[text()='Dashboard']");

    private final By adminMenu = By.xpath("//span[text()='Admin']");

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }

    public AdminPage openAdminPage() {
        click(adminMenu);
        return new AdminPage();
    }

}