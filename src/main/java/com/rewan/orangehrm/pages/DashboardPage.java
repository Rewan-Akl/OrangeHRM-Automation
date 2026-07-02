package com.rewan.orangehrm.pages;

import com.rewan.orangehrm.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private final By dashboardHeader =
            By.xpath("//h6[text()='Dashboard']");

    public boolean isDashboardDisplayed() {
        return isDisplayed(dashboardHeader);
    }

}